package com.ramper.gamification.service;

import com.ramper.gamification.domain.GameStats;

public interface GameService {

    GameStats newAttemptForUser(Long userId, Long attemptId, boolean correct);

    GameStats retrieveStatsForUser(Long userId);

}
