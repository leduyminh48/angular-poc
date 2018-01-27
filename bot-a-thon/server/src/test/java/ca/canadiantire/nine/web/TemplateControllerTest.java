package ca.canadiantire.nine.web;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ca.canadiantire.nine.domain.RecurringTemplate;
import ca.canadiantire.nine.domain.User;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class TemplateControllerTest extends AbstractControllerTest {

    private static final String CREATE_TEMPLATE_MOBILE = "/template/phoneOrder";
    private static final String CREATE_TEMPLATE_WEB = "/template/webOrder";
    private static ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void testPutTemplateFromPhone() throws Exception {
        when(userRepository.findOne(any())).thenReturn(new User());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(CREATE_TEMPLATE_MOBILE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(MAPPER.writeValueAsBytes(createPhoneOrder()));
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void testPutTemplateFromWeb() throws Exception {
        when(userRepository.findOne(any())).thenReturn(new User());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(CREATE_TEMPLATE_WEB)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(MAPPER.writeValueAsBytes(createWebOrder()));
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    private ObjectNode createPhoneOrder() {
        final ObjectNode phoneOrder = createOrderHeader();

        final ArrayNode phoneOrderItems = MAPPER.createArrayNode();
        phoneOrderItems.add(createPhoneOrderItem());
        phoneOrder.set("barCodes", phoneOrderItems);

        return phoneOrder;
    }

    private ObjectNode createPhoneOrderItem() {
        final ObjectNode phoneOrderItem = MAPPER.createObjectNode();
        phoneOrderItem.put("barCode", "12345");
        phoneOrderItem.put("quantity", 3);
        return phoneOrderItem;
    }

    private ObjectNode createWebOrder() {
        final ObjectNode phoneOrder = createOrderHeader();

        final ArrayNode phoneOrderItems = MAPPER.createArrayNode();
        phoneOrderItems.add(createWebOrderItem());
        phoneOrder.set("products", phoneOrderItems);

        return phoneOrder;
    }

    private ObjectNode createWebOrderItem() {
        final ObjectNode phoneOrderItem = MAPPER.createObjectNode();
        phoneOrderItem.put("id", "1");
        phoneOrderItem.put("quantity", 3);
        return phoneOrderItem;
    }

    private ObjectNode createOrderHeader() {
        final ObjectNode order = MAPPER.createObjectNode();
        order.put("userId", 12345L);
        order.put("startDate", LocalDate.now().toString());
        order.put("timeUnitAmount", 3);
        order.put("timeUnit", "DAY");
        return order;
    }
}