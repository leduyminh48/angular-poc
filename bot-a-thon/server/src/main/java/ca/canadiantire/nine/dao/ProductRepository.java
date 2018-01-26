package ca.canadiantire.nine.dao;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2017. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import ca.canadiantire.nine.domain.Product;

public interface ProductRepository extends CrudRepository <Product, Long> {

    Collection<Product> getProductsByCategoryId(Long categoryId);
}
