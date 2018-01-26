package ca.canadiantire.nine.web;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ca.canadiantire.nine.dao.CategoryRepository;
import ca.canadiantire.nine.dao.ProductRepository;

/**
 * @author Victor Letunovsky
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public abstract class AbstractControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected CategoryRepository categoryRepository;

    @MockBean
    protected ProductRepository productRepository;
}
