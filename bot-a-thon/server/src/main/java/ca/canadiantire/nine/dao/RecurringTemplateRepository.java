package ca.canadiantire.nine.dao;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import org.springframework.data.repository.CrudRepository;

import ca.canadiantire.nine.domain.RecurringTemplate;

public interface RecurringTemplateRepository extends CrudRepository<RecurringTemplate, Long>{
}
