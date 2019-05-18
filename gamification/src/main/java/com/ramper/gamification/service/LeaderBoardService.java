package com.ramper.gamification.service;

import java.util.List;

import com.ramper.gamification.domain.LeaderBoardRow;

public interface LeaderBoardService {

    List<LeaderBoardRow> getCurrentLeaderBoard();

}
