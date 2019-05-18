package com.ramper.gamification.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramper.gamification.domain.LeaderBoardRow;
import com.ramper.gamification.service.LeaderBoardService;

@RestController
@RequestMapping("/leader")
public class LeaderBoardController {

    private final LeaderBoardService leaderBoardService;

    public LeaderBoardController(final LeaderBoardService leaderBoardService) {
	this.leaderBoardService = leaderBoardService;
    }

    @GetMapping
    public List<LeaderBoardRow> getLeaderBoard() {
	return leaderBoardService.getCurrentLeaderBoard();
    }
}
