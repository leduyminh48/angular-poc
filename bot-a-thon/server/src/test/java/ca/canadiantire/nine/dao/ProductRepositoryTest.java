package ca.canadiantire.nine.dao;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ca.canadiantire.nine.domain.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ProductRepositoryTest extends AbstractRepositoryTest {

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

    @Test
    public void shouldGetProductByBarCode() {
        Product product = productRepository.getProductByBarCode("1234567890");
        assertEquals("Chocolate almonds", product.getName());
    }
}
