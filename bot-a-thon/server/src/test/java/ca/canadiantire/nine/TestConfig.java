package ca.canadiantire.nine;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ca.canadiantire.nine.converter.PhoneTemplateToRecurringTemplateConverter;
import ca.canadiantire.nine.dao.CategoryRepository;
import ca.canadiantire.nine.dao.ProductRepository;
import ca.canadiantire.nine.dao.RecurringItemRepository;
import ca.canadiantire.nine.dao.UserRepository;

/**
 * @author Victor Letunovsky
 */
@Configuration
public class TestConfig {

    @MockBean
    protected CategoryRepository categoryRepository;

    @MockBean
    protected ProductRepository productRepository;

    @MockBean
    protected UserRepository userRepository;

    @MockBean
    protected RecurringItemRepository recurringItemRepository;

    @MockBean
    protected PhoneTemplateToRecurringTemplateConverter converter;
}
