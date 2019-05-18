package com.ramper.gamification.client;

import com.ramper.gamification.client.dto.MultiplicationResultAttempt;

public interface MultiplicationResultAttemptClient {

    MultiplicationResultAttempt retrieveMultiplicationResultAttemptById(final Long multiplicationId);
}
