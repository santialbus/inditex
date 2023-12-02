package com.inditex.albus.inditex.infraestructure.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test integración contra el controlador")
    public void testGetPrice() throws Exception {
        String requestJson = "{\"productId\": 1, \"brandId\": 1, \"applicationDate\": \"2023-01-01\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/prices")
                        .contentType("application/json")
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
