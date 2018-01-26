package ca.canadiantire.nine.dao;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ca.canadiantire.nine.service.MailContentBuilder;

/**
 * @author Victor Letunovsky
 */
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@RunWith(SpringRunner.class)
public abstract class AbstractRepositoryTest {

    @MockBean
    protected JavaMailSender mailSender;

    @MockBean
    protected MailContentBuilder mailContentBuilder;
}
