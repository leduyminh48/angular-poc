package ca.canadiantire.nine.domain;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2017. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    private LocalDateTime dateTime;

    public Order() {
        this.dateTime = LocalDateTime.now();
    }

    public Order(final User user) {
        this.dateTime = LocalDateTime.now();
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
