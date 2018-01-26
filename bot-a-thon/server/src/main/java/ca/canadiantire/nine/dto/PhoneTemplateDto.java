package ca.canadiantire.nine.dto;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2017. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.time.LocalDate;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import ca.canadiantire.nine.enums.TimeUnits;

@JsonInclude
public class PhoneTemplateDto {

    private Long userId;

    private LocalDate startDate;

    private Integer timeUnitAmount;

    private TimeUnits timeUnit;

    private Collection<PhoneTemplateItem> barCodes;

    private class PhoneTemplateItem {

        private String barCode;

        private Integer quantity;
    }
}


