package ca.canadiantire.nine.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

    public Product getProductById(Long id) {
        return productRepository.findOne(id);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Collection<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.getProductsByCategoryId(categoryId);
    }

    public Collection<Product> getMostPopularProducts() {
        Map<Long, Product> productByCategoryMap = new HashMap<>();
        // Get one product for each category
        productRepository.findAll().forEach(p ->
                productByCategoryMap.computeIfAbsent(p.getCategory().getId(), categoryId -> p));
        return productByCategoryMap.values();
    }
}
