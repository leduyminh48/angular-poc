package ca.canadiantire.nine.converter;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.canadiantire.nine.dao.ProductRepository;
import ca.canadiantire.nine.dao.RecurringItemRepository;
import ca.canadiantire.nine.domain.RecurringItem;
import ca.canadiantire.nine.domain.RecurringTemplate;
import ca.canadiantire.nine.dto.PhoneTemplateDto;

@Service
public class PhoneTemplateToRecurringTemplateConverter
        extends AbstractTemplateToRecurringTemplateConverter<PhoneTemplateDto> {

    @Autowired
    private RecurringItemRepository recurringItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    protected void convertItems(final PhoneTemplateDto templateDto, final RecurringTemplate template) {
        final List<RecurringItem> items = templateDto.getBarCodes().stream()
                .map(item -> convertItem(template, item))
                .collect(Collectors.toList());
        template.setRecurringItems(items);
        recurringItemRepository.save(items);
    }

    private RecurringItem convertItem(final RecurringTemplate template,
                                      final PhoneTemplateDto.PhoneTemplateItem phoneTemplateItem) {
        RecurringItem recurringItem = new RecurringItem();
        recurringItem.setTemplate(template);
        recurringItem.setProduct(productRepository.getProductByBarCode(phoneTemplateItem.getBarCode()));
        recurringItem.setQuantity(phoneTemplateItem.getQuantity());
        return recurringItem;
    }
}
