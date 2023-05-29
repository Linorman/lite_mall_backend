package com.softwarelearn.lite_mall_backend.controller;

import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.controller.mall.OrderNumController;
import com.softwarelearn.lite_mall_backend.service.OrderNumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

public class OrderNumControllerTest {
    private MockMvc mockMvc;

    @Mock
    private OrderNumService orderNumService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new OrderNumController()).build();
    }

    @Test
    public void testOrderNumIncrease() throws Exception {
        when(orderNumService.updateOrderNum()).thenReturn(R.success(ResultCode.SUCCESS, null));
        mockMvc.perform(MockMvcRequestBuilders.post("/mall/orderNumIncrease")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errno").value(0));
    }

    @Test
    public void testGetOrderNum() throws Exception {
        when(orderNumService.getOrderNum()).thenReturn(R.success(ResultCode.SUCCESS, null));
        mockMvc.perform(MockMvcRequestBuilders.get("/mall/getOrderNum")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errno").value(0));
    }
}