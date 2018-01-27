package ca.canadiantire.nine.converter;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.canadiantire.nine.dao.ProductRepository;
import ca.canadiantire.nine.dao.RecurringItemRepository;
import ca.canadiantire.nine.domain.RecurringItem;
import ca.canadiantire.nine.domain.RecurringTemplate;
import ca.canadiantire.nine.dto.WebTemplateDto;

@Component
public class WebTemplateToRecurringTemplateConverter
        extends AbstractTemplateToRecurringTemplateConverter<WebTemplateDto> {

    @Autowired
    private RecurringItemRepository recurringItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    protected void convertItems(final WebTemplateDto templateDto, final RecurringTemplate template) {
        final List<RecurringItem> items = templateDto.getProducts().stream()
                .map(item -> convertItem(template, item))
                .collect(Collectors.toList());
        template.setRecurringItems(items);
        recurringItemRepository.save(items);
    }

    private RecurringItem convertItem(final RecurringTemplate template,
                                      final WebTemplateDto.WebTemplateItem webTemplateItem) {
        RecurringItem recurringItem = new RecurringItem();
        recurringItem.setTemplate(template);
        recurringItem.setProduct(productRepository.findOne(Long.valueOf(webTemplateItem.getId())));
        recurringItem.setQuantity(webTemplateItem.getQuantity());
        return recurringItem;
    }
}
