package ca.canadiantire.nine.domain;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RecurringItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = RecurringTemplate.class, cascade = CascadeType.PERSIST)
    private RecurringTemplate template;

    @OneToOne
    private Product product;

    private Integer quantity;

    public RecurringItem() {
    }

    public RecurringItem(final RecurringTemplate template, final Product product, final Integer quantity) {
        this.template = template;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public RecurringTemplate getTemplate() {
        return template;
    }

    public void setTemplate(final RecurringTemplate template) {
        this.template = template;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
}
