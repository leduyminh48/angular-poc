package ca.canadiantire.nine.web;

import org.junit.Test;
import org.springframework.http.MediaType;

import ca.canadiantire.nine.domain.Product;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Victor Letunovsky
 */
public class ProductControllerTest extends AbstractControllerTest {

    @Test
    public void shouldGetProductById() throws Exception {
        when(productRepository.findOne(1L)).thenReturn(new Product());
        mockMvc.perform(get("/product/1")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}
