package ca.canadiantire.nine.dto;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class WebTemplateDto extends AbstractTemplateDto {

    private Collection<WebTemplateItem> products;

    public Collection<WebTemplateItem> getProducts() {
        return products;
    }

    public void setProducts(final Collection<WebTemplateItem> products) {
        this.products = products;
    }

    public static class WebTemplateItem {

        private String id;

        private Integer quantity;

        public String getId() {
            return id;
        }

        public void setId(final String id) {
            this.id = id;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(final Integer quantity) {
            this.quantity = quantity;
        }
    }
}


