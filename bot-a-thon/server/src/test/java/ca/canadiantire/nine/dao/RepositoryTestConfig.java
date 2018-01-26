package ca.canadiantire.nine.dao;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

import ca.canadiantire.nine.service.MailContentBuilder;

/**
 * @author Victor Letunovsky
 */
@Configuration
public class RepositoryTestConfig {

    @MockBean
    private MailContentBuilder mailContentBuilder;
}
