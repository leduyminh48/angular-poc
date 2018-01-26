package ca.canadiantire.nine.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.canadiantire.nine.dao.ProductRepository;
import ca.canadiantire.nine.domain.Product;

/**
 * @author Victor Letunovsky
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Collection<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.getProductsByCategoryId(categoryId);
    }
}
