/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

package ca.canadiantire.nine.service;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import ca.canadiantire.nine.domain.Product;
import ca.canadiantire.nine.domain.RecurringTemplate;
import ca.canadiantire.nine.domain.User;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailContentBuilder mailContentBuilder;

    @Value("${email.subject.repeatableItemsOrderedNotification}")
    private String REPEATABLE_ITEMS_SUBJECT;
    @Value("${email.subject.recurringOrderIsReadyNotification}")
    private String RECURRING_ORDER_READY_SUBJECT;
    @Value("${email.img.logo}")
    private String LOGO_PATH;
    @Value("${email.img.footer}")
    private String FOOTER_PATH;

    public void sendRepeatableItemsOrderedNotification(final String recipient, final User user,
                                                       final List<Product> productsToOfferRecurring) {
        final String content = mailContentBuilder.buildRepeatableItemsOrdered(recipient, user,
                productsToOfferRecurring);
        send(prepareMessage(recipient, REPEATABLE_ITEMS_SUBJECT, content));
    }

    public void sendRecurringOrderIsReadyNotification(final String recipient, final User user,
                                                      final RecurringTemplate recurringTemplate) {
        final String content = mailContentBuilder.buildRecurringOrderIsReady(recipient, user,
                recurringTemplate);
        send(prepareMessage(recipient, RECURRING_ORDER_READY_SUBJECT, content));
    }

    public MimeMessagePreparator prepareMessage(final String recipient, final String subject,
                                                final String content) {
        return (MimeMessage mimeMessage) -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);
            messageHelper.addAttachment("logo.jpg", new ClassPathResource(LOGO_PATH));
            messageHelper.addAttachment("footer.jpg", new ClassPathResource(FOOTER_PATH));
        };
    }

    public void send(final MimeMessagePreparator message) {
        try {
            mailSender.send(message);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    }
}
