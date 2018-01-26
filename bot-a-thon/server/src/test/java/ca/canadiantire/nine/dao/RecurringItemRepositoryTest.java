package ca.canadiantire.nine.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ca.canadiantire.nine.domain.RecurringItem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author Victor Letunovsky
 */
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@RunWith(SpringRunner.class)
public class RecurringItemRepositoryTest {

    @Autowired
    private RecurringItemRepository repository;

    @Test
    public void shouldGetRecurringItemsByRecurringTemplateId() {
        final List<RecurringItem> items = repository.getRecurringItemsByTemplateId(1L);
        assertNotNull(items);
    }

}
