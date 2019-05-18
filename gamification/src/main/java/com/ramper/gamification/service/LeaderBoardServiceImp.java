package com.ramper.gamification.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ramper.gamification.domain.LeaderBoardRow;
import com.ramper.gamification.repository.ScoreCardRepository;

@Service
public class LeaderBoardServiceImp implements LeaderBoardService {

    private ScoreCardRepository scoreCardRepository;

    LeaderBoardServiceImp(ScoreCardRepository scoreCardRepository) {
	this.scoreCardRepository = scoreCardRepository;
    }

    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard() {
	return scoreCardRepository.findFirst10();
    }

}
