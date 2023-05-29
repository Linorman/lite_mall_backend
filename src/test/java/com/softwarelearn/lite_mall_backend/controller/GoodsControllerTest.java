package com.softwarelearn.lite_mall_backend.controller;

import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.controller.mall.GoodsController;
import com.softwarelearn.lite_mall_backend.pojo.mall.GoodsInfo;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.service.GoodsService;
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

public class GoodsControllerTest {
    private MockMvc mockMvc;

    @Mock
    private GoodsService goodsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        GoodsController goodsController = new GoodsController();
        mockMvc = MockMvcBuilders.standaloneSetup(goodsController).build();
    }

    @Test
    public void testGetAllGoods() throws Exception {
        when(goodsService.getAllGoods()).thenReturn(R.success(ResultCode.SUCCESS, null));
        mockMvc.perform(MockMvcRequestBuilders.get("/mall/getAllGoods")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errno").value(0));
    }

    @Test
    public void testGetGoods() throws Exception {
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setId(1L);
        when(goodsService.getGoods(goodsInfo)).thenReturn(R.success(ResultCode.SUCCESS, null));
        mockMvc.perform(MockMvcRequestBuilders.post("/mall/getGoods")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errno").value(0));
    }
}
