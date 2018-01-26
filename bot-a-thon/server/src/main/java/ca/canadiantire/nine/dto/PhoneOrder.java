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
public class PhoneOrder {
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("startDate")
    private LocalDate startDate;
    @JsonProperty("timeUnitAmount")
    private Integer timeUnitAmount;
    @JsonProperty("timeUnit")
    private TimeUnits timeUnit;
    @JsonProperty("barCodes")
    private Collection<PhoneOrderItem> phoneOrderItemCollection;

    public class PhoneOrderItem {
        @JsonProperty("barCode")
        private String barcode;
        @JsonProperty("quantity")
        private Integer quantity;
    }
}


