package com.ramper.gamification.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public final class BadgeCard {

    @Id
    @GeneratedValue
    @Column(name = "BADGE_ID")
    private final Long id;

    private final Long userId;
    private final long badgeTimeStamp;
    private final Badge badge;

    public BadgeCard() {
	this(null, null, 0, null);
    }

    public BadgeCard(final Long userID, final Badge badge) {
	this(null, userID, System.currentTimeMillis(), badge);
    }

}
