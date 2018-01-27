package ca.canadiantire.nine.service;

import java.lang.reflect.Array;
import java.util.*;

import ca.canadiantire.nine.dao.RecurringItemRepository;
import ca.canadiantire.nine.domain.RecurringItem;
import ca.canadiantire.nine.domain.RecurringTemplate;
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

    @Autowired
    RecurringItemRepository itemRepository;

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

    public List<Map.Entry<Product, Integer>> getTop5Products() {
        List<RecurringItem> recurringItems = itemRepository.getAllRecurringItems();
        Map<Product, Integer> groupRecurringItems = new HashMap<>();
        for (RecurringItem recurringItem : recurringItems) {
            Product product = recurringItem.getProduct();
            int ordered = recurringItem.getQuantity();
            groupRecurringItems.put(product,
                    (groupRecurringItems.getOrDefault(product, 0)) + ordered);
        }

        List<Map.Entry<Product, Integer>> entries = new ArrayList<>(groupRecurringItems.entrySet());
        entries.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        return entries.subList(0, 5);
    }
}
