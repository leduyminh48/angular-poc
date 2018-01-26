package ca.canadiantire.nine.dao;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2017. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ca.canadiantire.nine.domain.Category;
import ca.canadiantire.nine.domain.Product;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@RunWith(SpringRunner.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testGetProduct() {
        final Iterable<Product> products = productRepository.findAll();
        assertTrue(products.iterator().next() != null);
    }

    @Test
    public void testGetProductByCategoryId() {
        Collection<Product> products = productRepository.getProductsByCategoryId(1L);
        assertFalse(products.isEmpty());
    }
}
