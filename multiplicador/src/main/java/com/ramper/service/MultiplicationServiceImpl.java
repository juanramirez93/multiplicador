package com.ramper.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ramper.domain.Multiplication;
import com.ramper.domain.MultiplicationResultAttempt;
import com.ramper.domain.User;
import com.ramper.event.EventDispatcher;
import com.ramper.event.MultiplicationSolvedEvent;
import com.ramper.repository.MultiplicationResultAttemptRepository;
import com.ramper.repository.UserRepository;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;
    private UserRepository userRepository;
    private MultiplicationResultAttemptRepository attemptRepository;
    private EventDispatcher eventDispatcher;

    @Autowired
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService,
	    final MultiplicationResultAttemptRepository attemptRepository, final UserRepository userRepository) {
	this.randomGeneratorService = randomGeneratorService;
	this.attemptRepository = attemptRepository;
	this.userRepository = userRepository;
    }

    @Override
    public Multiplication createRandomMultiplication() {
	int fA = randomGeneratorService.generateRandomFactor();
	int fB = randomGeneratorService.generateRandomFactor();
	return new Multiplication(fA, fB);
    }

    @Transactional
    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt attempt) {
	// Check if the user already exists for that alias
	Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());

	// Avoids 'hack' attempts
	Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as correct!!");

	// Check if the attempt is correct
	boolean isCorrect = attempt.getResultAttempt() == attempt.getMultiplication().getFactorA()
		* attempt.getMultiplication().getFactorB();

	MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(user.orElse(attempt.getUser()),
		attempt.getMultiplication(), attempt.getResultAttempt(), isCorrect);

	// Stores the attempt
	attemptRepository.save(checkedAttempt);

	// Communicates the result via Event
	eventDispatcher.send(new MultiplicationSolvedEvent(checkedAttempt.getId(), checkedAttempt.getUser().getId(),
		checkedAttempt.isCorrect()));

	return isCorrect;
    }

    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
	return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
    }

}
