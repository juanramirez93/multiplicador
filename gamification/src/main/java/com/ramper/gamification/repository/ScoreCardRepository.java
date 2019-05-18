package com.ramper.gamification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ramper.gamification.domain.LeaderBoardRow;
import com.ramper.gamification.domain.ScoreCard;

public interface ScoreCardRepository extends CrudRepository<ScoreCard, Long> {

    List<ScoreCard> findByUserIdOrderByScoreTimeStampDesc(final Long userID);

    @Query("SELECT SUM(s.score) FROM com.ramper.gamification.domain.ScoreCard s WHERE s.userId = :userId GROUP BY s.userId")
    int getTotalScoreForUser(@Param("userId") final Long userId);

    @Query("SELECT NEW com.ramper.gamification.domain.LeaderBoardRow(s.userId, SUM(s.score)) FROM com.ramper.gamification.domain.ScoreCard s GROUP BY s.userId ORDER BY SUM(s.score) DESC")
    List<LeaderBoardRow> findFirst10();

}
