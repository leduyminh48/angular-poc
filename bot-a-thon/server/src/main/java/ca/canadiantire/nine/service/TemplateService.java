package ca.canadiantire.nine.service;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.canadiantire.nine.domain.Product;
import ca.canadiantire.nine.domain.RecurringItem;
import ca.canadiantire.nine.domain.RecurringTemplate;

@Service
public class TemplateService {

    public BigDecimal calculateTemplateAmount(RecurringTemplate template) {
        final Optional<BigDecimal> amount = template.getRecurringItems().stream()
                .map(RecurringItem::getProduct)
                .map(Product::getPrice)
                .reduce((p1, p2) -> p1.add(p2));

        return amount.get();
    }


    public BigDecimal calculateTemplateDiscount(RecurringTemplate template) {
        final Collection<RecurringItem> recurringItems = template.getRecurringItems();
        final BigDecimal discountPerStream = getDiscountPercent(recurringItems.size());
        final Optional<BigDecimal> discountAmount = recurringItems.stream()
                .map(RecurringItem::getProduct)
                .map(Product::getPrice)
                .reduce((p1, p2) -> p1.multiply(discountPerStream).add(p2.multiply(discountPerStream)));
        return discountAmount.get();
    }

    private BigDecimal getDiscountPercent(final int size) {
        if (size >= 3 && size < 5) {
            return new BigDecimal("0.08");
        } else if (size >= 5 && size < 10) {
            return new BigDecimal("0.10");
        } else if (size >= 10) {
            return new BigDecimal("0.15");
        } else {
            return new BigDecimal("0");
        }
    }

}
