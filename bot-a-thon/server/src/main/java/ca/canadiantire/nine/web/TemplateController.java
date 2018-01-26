package ca.canadiantire.nine.web;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ca.canadiantire.nine.converter.PhoneTemplateToRecurringTemplateConverter;
import ca.canadiantire.nine.dto.PhoneTemplateDto;
import ca.canadiantire.nine.service.ProductService;

@RestController
@RequestMapping("template")
public class TemplateController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PhoneTemplateToRecurringTemplateConverter templateConverter;

    @RequestMapping(value = "phoneOrder", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
    @ResponseStatus(value = HttpStatus.OK)
    public void putTemplateFromPhone(@RequestBody @Valid final PhoneTemplateDto phoneTemplateDto) {
        templateConverter.convertAndSave(phoneTemplateDto);
    }
}
