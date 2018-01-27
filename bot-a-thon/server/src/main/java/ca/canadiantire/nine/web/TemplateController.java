package ca.canadiantire.nine.web;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ca.canadiantire.nine.converter.PhoneTemplateToRecurringTemplateConverter;
import ca.canadiantire.nine.converter.WebTemplateToRecurringTemplateConverter;
import ca.canadiantire.nine.domain.RecurringTemplate;
import ca.canadiantire.nine.domain.User;
import ca.canadiantire.nine.dto.PhoneTemplateDto;
import ca.canadiantire.nine.dto.WebProductTemplateDto;
import ca.canadiantire.nine.dto.WebTemplateDto;
import ca.canadiantire.nine.service.EmailService;
import ca.canadiantire.nine.service.ProductService;
import ca.canadiantire.nine.service.RecurringTemplateService;

@RestController
@RequestMapping("template")
public class TemplateController {

    @Autowired
    private ProductService productService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PhoneTemplateToRecurringTemplateConverter phoneTemplateConverter;

    @Autowired
    private WebTemplateToRecurringTemplateConverter webTemplateConverter;

    @Autowired
    private RecurringTemplateService recurringTemplateService;

    @RequestMapping(value = "phoneOrder", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
    @ResponseStatus(value = HttpStatus.OK)
    public void putTemplateFromPhone(@RequestBody @Valid final PhoneTemplateDto phoneTemplateDto) {
        final RecurringTemplate template = phoneTemplateConverter.convertAndSave(phoneTemplateDto);
        postSaveActions(template);
    }

    @RequestMapping(value = "webOrder", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void putTemplateFromWeb(@RequestBody @Valid final WebTemplateDto webTemplateDto) {
        final RecurringTemplate template = webTemplateConverter.convertAndSave(webTemplateDto);
        postSaveActions(template);
    }

    private void postSaveActions(final RecurringTemplate template) {
        final User user = template.getUser();
        emailService.sendRecurringOrderIsReadyNotification(user.getEmail(), user, template);
    }

    @RequestMapping("{id}")
    public WebProductTemplateDto getTemplateForWeb(@PathVariable("id") Long id) {
        return null;
    }
}
