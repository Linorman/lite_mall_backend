package com.softwarelearn.lite_mall_backend.controller;

import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.controller.mall.OnlineUserNumController;
import com.softwarelearn.lite_mall_backend.service.OnlineUserNumService;
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

public class OnlineUserNumControllerTest {
    private MockMvc mockMvc;

    @Mock
    private OnlineUserNumService onlineUserNumService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new OnlineUserNumController()).build();
    }

    @Test
    public void testOnlineUserNumIncrease() throws Exception {
        when(onlineUserNumService.updateOnlineUserNum()).thenReturn(R.success(ResultCode.SUCCESS, null));
        mockMvc.perform(MockMvcRequestBuilders.post("/mall/onlineUserNumIncrease")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errno").value(0));
    }

    @Test
    public void testOnlineUserNumReset() throws Exception {
        when(onlineUserNumService.resetOnlineUserNum()).thenReturn(R.success(ResultCode.SUCCESS, null));
        mockMvc.perform(MockMvcRequestBuilders.post("/mall/onlineUserNumReset")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errno").value(0));
    }
}