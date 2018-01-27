package ca.canadiantire.nine.web;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ca.canadiantire.nine.dao.CategoryRepository;
import ca.canadiantire.nine.dao.ProductRepository;
import ca.canadiantire.nine.dao.RecurringItemRepository;
import ca.canadiantire.nine.dao.RecurringTemplateRepository;
import ca.canadiantire.nine.dao.UserRepository;
import ca.canadiantire.nine.service.TemplateService;
import ca.canadiantire.nine.service.EmailService;

/**
 * @author Victor Letunovsky
 */
@WebMvcTest(ProductController.class)
@RunWith(SpringRunner.class)
public abstract class AbstractControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected ProductRepository productRepository;

    @MockBean
    protected UserRepository userRepository;

    @MockBean
    protected RecurringItemRepository recurringItemRepository;

    @MockBean
    protected RecurringTemplateRepository templateRepository;

    @MockBean
    protected CategoryRepository categoryRepository;

    @MockBean
    protected JavaMailSender mailSender;

    @MockBean
    protected TemplateService templateService;

    @MockBean
    protected EmailService emailService;
}
