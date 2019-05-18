package com.ramper.gamification.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ramper.gamification.domain.BadgeCard;

public interface BadgeCardRepository extends CrudRepository<BadgeCard, Long> {

    List<BadgeCard> findByUserIdOrderByBadgeTimeStampDesc(final Long userId);

}
