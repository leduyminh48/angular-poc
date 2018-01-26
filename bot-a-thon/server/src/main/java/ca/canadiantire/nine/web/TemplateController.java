package ca.canadiantire.nine.web;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2017. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ca.canadiantire.nine.dto.PhoneTemplateDto;

@RestController
@RequestMapping("template")
public class TemplateController {

    @RequestMapping(value = "phoneOrder", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void putTemplateFromPhone(@RequestBody @Valid final PhoneTemplateDto phoneTemplateDto) {
        phoneTemplateDto.getClass();
    }
}
