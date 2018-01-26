package ca.canadiantire.nine.converter;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ca.canadiantire.nine.dao.ProductRepository;
import ca.canadiantire.nine.dao.RecurringItemRepository;
import ca.canadiantire.nine.dao.UserRepository;
import ca.canadiantire.nine.domain.RecurringItem;
import ca.canadiantire.nine.domain.RecurringTemplate;
import ca.canadiantire.nine.dto.PhoneTemplateDto;
import ca.canadiantire.nine.enums.TimeUnits;

@Service
public class PhoneTemplateToRecurringTemplateConverter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecurringItemRepository recurringItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public RecurringTemplate convertAndSave(PhoneTemplateDto templateDto) {
        RecurringTemplate template = new RecurringTemplate();
        template.setUser(userRepository.findOne(templateDto.getUserId()));
        template.setStartDate(LocalDate.parse(templateDto.getStartDate()));
        template.setTimeUnitAmount(templateDto.getTimeUnitAmount());
        template.setTimeUnit(TimeUnits.valueOf(templateDto.getTimeUnit()));
        final List<RecurringItem> items = templateDto.getBarCodes().stream()
                .map(phoneTemplateItem -> convertItem(template, phoneTemplateItem))
                .collect(Collectors.toList());
        recurringItemRepository.save(items);
        return template;
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
