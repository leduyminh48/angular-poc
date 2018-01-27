package ca.canadiantire.nine.converter;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */


import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import ca.canadiantire.nine.dao.ProductRepository;
import ca.canadiantire.nine.dao.RecurringItemRepository;
import ca.canadiantire.nine.dao.RecurringTemplateRepository;
import ca.canadiantire.nine.dao.UserRepository;
import ca.canadiantire.nine.domain.Product;
import ca.canadiantire.nine.domain.RecurringItem;
import ca.canadiantire.nine.domain.User;
import ca.canadiantire.nine.dto.PhoneTemplateDto;
import ca.canadiantire.nine.dto.WebTemplateDto;
import ca.canadiantire.nine.service.TemplateService;

import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebTemplateToRecurringTemplateConverterTest {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private RecurringItemRepository recurringItemRepository;

    @MockBean
    private RecurringTemplateRepository templateRepository;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private TemplateService templateService;

    @Autowired
    private WebTemplateToRecurringTemplateConverter testingInstance;

    @Test
    public void shouldSaveTemplate() {
        WebTemplateDto templateDto = new WebTemplateDto();
        templateDto.setUserId(2L);
        templateDto.setTimeUnit("DAY");
        templateDto.setTimeUnitAmount(3);
        templateDto.setStartDate("2018-01-01");
        templateDto.setProducts(Lists.newArrayList(createItem("1", 3)));
        Product product = mock(Product.class);
        when(productRepository.findOne(anyLong())).thenReturn(product);
        when(userRepository.findOne(2L)).thenReturn(new User());

        testingInstance.convertAndSave(templateDto);

        Mockito.verify(recurringItemRepository).save(anyCollectionOf(RecurringItem.class));
    }

    private WebTemplateDto.WebTemplateItem createItem(final String id, final int quantity) {
        WebTemplateDto.WebTemplateItem item = new WebTemplateDto.WebTemplateItem();
        item.setId(id);
        item.setQuantity(quantity);
        return item;
    }
}