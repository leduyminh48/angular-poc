package ca.canadiantire.nine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.canadiantire.nine.domain.Category;
import ca.canadiantire.nine.service.CatalogService;

/**
 * @author Victor Letunovsky (@vletunovsky)
 */
@RestController
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @RequestMapping("categories")
    public Iterable<Category> getAllCategories() {
        return catalogService.getAllCategories();
    }

    @RequestMapping("category/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") Long categoryId) {
        return catalogService.getCategoryById(categoryId);
    }
}
