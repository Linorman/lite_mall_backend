package com.softwarelearn.lite_mall_backend.controller;

import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.controller.mall.VisitNumController;
import com.softwarelearn.lite_mall_backend.service.VisitNumService;
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

public class VisitNumControllerTest {
    private MockMvc mockMvc;

    @Mock
    private VisitNumService visitNumService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new VisitNumController()).build();
    }

    @Test
    public void testVisitNumIncrease() throws Exception {
        when(visitNumService.updateVisitNum()).thenReturn(R.success(ResultCode.SUCCESS, null));
        mockMvc.perform(MockMvcRequestBuilders.post("/mall/visitNumIncrease")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errno").value(0));
    }

    @Test
    public void testGetVisitNum() throws Exception {
        when(visitNumService.getVisitNum()).thenReturn(R.success(ResultCode.SUCCESS, null));
        mockMvc.perform(MockMvcRequestBuilders.get("/mall/getVisitNum")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errno").value(0));
    }
}