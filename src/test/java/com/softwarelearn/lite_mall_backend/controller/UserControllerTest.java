package com.softwarelearn.lite_mall_backend.controller;

import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.controller.user.UserController;
import com.softwarelearn.lite_mall_backend.pojo.user.UserInfo;
import com.softwarelearn.lite_mall_backend.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static net.minidev.json.JSONValue.toJSONString;

@SpringBootTest
public class UserControllerTest {
    private static MockMvc mockMvc;
    private static UserService userService = Mockito.mock(UserService.class);

    @BeforeAll
    public static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void shouldReturn200AndSuccessMessageWhenRegister() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("testUsername");
        userInfo.setPassword("testPassword");
        R expectedResult = R.success(ResultCode.SUCCESS, "注册成功");
        Mockito.when(userService.register(Mockito.any(UserInfo.class))).thenReturn(expectedResult);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
                        .content(toJSONString(userInfo))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(toJSONString(expectedResult)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void shouldReturn200AndSuccessMessageWhenSignIn() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("testUsername");
        userInfo.setPassword("testPassword");
        R expectedResult = R.success(ResultCode.SUCCESS, "登录成功");
        Mockito.when(userService.signIn(Mockito.any(UserInfo.class))).thenReturn(expectedResult);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/userSignIn")
                        .content(toJSONString(userInfo))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(toJSONString(expectedResult)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void shouldReturn200AndSuccessMessageWhenGetUserInfo() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("testUsername");
        R expectedResult = R.success(ResultCode.SUCCESS, "获取用户信息成功");
        Mockito.when(userService.getUserInfo(Mockito.any(UserInfo.class))).thenReturn(expectedResult);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/getUserInfo")
                        .content(toJSONString(userInfo))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(toJSONString(expectedResult)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void shouldReturn200AndSuccessMessageWhenLogout() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("testUsername");
        userInfo.setPassword("testPassword");
        R expectedResult = R.success(ResultCode.SUCCESS, "登出成功");
        Mockito.when(userService.logout(Mockito.any(UserInfo.class))).thenReturn(expectedResult);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/userLogout")
                        .content(toJSONString(userInfo))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(toJSONString(expectedResult)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void shouldReturn200AndSuccessMessageWhenSetUserInfo() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("testUsername");
        userInfo.setPassword("testPassword");
        R expectedResult = R.success(ResultCode.SUCCESS, "设置用户信息成功");
        Mockito.when(userService.setUserInfo(Mockito.any(UserInfo.class))).thenReturn(expectedResult);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/setUserInfo")
                        .content(toJSONString(userInfo))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(toJSONString(expectedResult)))
                .andDo(MockMvcResultHandlers.print());
    }
}
