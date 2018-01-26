package ca.canadiantire.nine.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ca.canadiantire.nine.domain.RecurringItem;

import static org.junit.Assert.assertNotNull;

/**
 * @author Victor Letunovsky
 */
public class RecurringItemRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private RecurringItemRepository repository;

    @Test
    public void shouldGetRecurringItemsByRecurringTemplateId() {
        final List<RecurringItem> items = repository.getRecurringItemsByTemplateId(1L);
        assertNotNull(items);
    }

}
