package com.ramper.gamification.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ramper.gamification.client.dto.MultiplicationResultAttempt;

@Component
public class MultiplicationResultAttemptClientImp implements MultiplicationResultAttemptClient {

    private final RestTemplate restTemplate;
    private final String multiplicationHost;

    @Autowired
    public MultiplicationResultAttemptClientImp(RestTemplate restTemplate,
	    @Value("${multiplicationHost}") final String multiplicationHost) {
	this.restTemplate = restTemplate;
	this.multiplicationHost = multiplicationHost;
    }

    @Override
    public MultiplicationResultAttempt retrieveMultiplicationResultAttemptById(final Long multiplicationId) {
	return restTemplate.getForObject(multiplicationHost + "/results/" + multiplicationId,
		MultiplicationResultAttempt.class);
    }

}
