package ca.canadiantire.nine.domain;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ca.canadiantire.nine.enums.TimeUnits;

@Entity
public class RecurringTemplate {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    private String name;

    private Boolean active;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer timeUnitAmount;

    private TimeUnits timeUnit;

    private BigDecimal amount;

    private BigDecimal discount;

    @OneToMany
    private Collection<RecurringItem> recurringItems;

    public RecurringTemplate() {
    }

    public RecurringTemplate(final User user, final String name, final Boolean active, final LocalDate startDate,
                             final LocalDate endDate, final Integer timeUnitAmount, final TimeUnits timeUnit, final
                             BigDecimal amount, final BigDecimal discount, final Collection<RecurringItem>
                                     recurringItems) {
        this.user = user;
        this.name = name;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeUnitAmount = timeUnitAmount;
        this.timeUnit = timeUnit;
        this.amount = amount;
        this.discount = discount;
        this.recurringItems = recurringItems;
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

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getTimeUnitAmount() {
        return timeUnitAmount;
    }

    public void setTimeUnitAmount(final Integer timeUnitAmount) {
        this.timeUnitAmount = timeUnitAmount;
    }

    public TimeUnits getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(final TimeUnits timeUnit) {
        this.timeUnit = timeUnit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(final BigDecimal discount) {
        this.discount = discount;
    }

    public Collection<RecurringItem> getRecurringItems() {
        return recurringItems;
    }

    public void setRecurringItems(final Collection<RecurringItem> recurringItems) {
        this.recurringItems = recurringItems;
    }
}
