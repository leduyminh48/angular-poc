package ca.canadiantire.nine.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ca.canadiantire.nine.domain.Category;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Victor Letunovsky
 */
public class CategoryRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testGetAll() {
        final List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        assertFalse(categories.isEmpty());
    }

    @Test
    public void shouldGetCategoryById() {
        final Category categoryExpected = categoryRepository.findAll().iterator().next();
        final Category category = categoryRepository.findOne(categoryExpected.getId());

        assertTrue(category.getName().equals(categoryExpected.getName()));
    }
}
