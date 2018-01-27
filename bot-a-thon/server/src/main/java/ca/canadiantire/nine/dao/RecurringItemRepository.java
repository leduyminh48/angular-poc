package ca.canadiantire.nine.dao;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.canadiantire.nine.domain.RecurringItem;

public interface RecurringItemRepository extends CrudRepository<RecurringItem, Long> {

    List<RecurringItem> getRecurringItemsByTemplateId(Long recurringTemplateId);

    List<RecurringItem> getAllRecurringItems();
}
