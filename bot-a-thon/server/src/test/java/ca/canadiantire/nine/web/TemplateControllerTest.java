package ca.canadiantire.nine.web;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2017. Canadian Tire Corporation, Ltd. All rights reserved.
 */


//@RunWith(SpringJUnit4ClassRunner.class)
public class TemplateControllerT {

    private static ObjectMapper MAPPER = new ObjectMapper();
    private static final String CREATE_TEMPLATE = "/template/phoneOrder";

    private TemplateController templateController;
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(templateController).build();

//    @Test
    public void testPutTemplateFromPhone() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(CREATE_TEMPLATE)
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(MAPPER.writeValueAsBytes(createPhoneOrder()));
        mockMvc.perform(requestBuilder);
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