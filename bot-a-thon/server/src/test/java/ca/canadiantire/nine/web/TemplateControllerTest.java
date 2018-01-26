package ca.canadiantire.nine.web;

/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2018. Canadian Tire Corporation, Ltd. All rights reserved.
 */

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ca.canadiantire.nine.converters.PhoneTemplateToRecurringTemplateConverter;

import static org.mockito.Matchers.anyCollection;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TemplateController.class)
public class TemplateControllerTest extends AbstractControllerTest{

    private static ObjectMapper MAPPER = new ObjectMapper();
    private static final String CREATE_TEMPLATE = "/template/phoneOrder";

    @Test
    public void testPutTemplateFromPhone() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(CREATE_TEMPLATE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(MAPPER.writeValueAsBytes(createPhoneOrder()));
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }


    private ObjectNode createPhoneOrder() {

        final ObjectNode phoneOrder = MAPPER.createObjectNode();
        final ArrayNode phoneOrderItems = MAPPER.createArrayNode();
        phoneOrder.put("userId", 12345L);
        phoneOrder.put("startDate", LocalDate.now().toString());
        phoneOrder.put("timeUnitAmount", 3);
        phoneOrder.put("timeUnit", "DAY");
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
}