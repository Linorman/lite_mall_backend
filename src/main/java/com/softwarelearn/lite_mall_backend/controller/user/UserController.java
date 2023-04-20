package com.softwarelearn.lite_mall_backend.controller.user;

import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.user.UserInfo;
import com.softwarelearn.lite_mall_backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * @author linorman
 * @data 2023/04/16
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public R register(UserInfo userInfo){
        return userService.register(userInfo);
    }

    @PostMapping("/userSignIn")
    public R signIn(UserInfo userInfo){
        return userService.signIn(userInfo);
    }

    @GetMapping("/getUserInfo")
    public R getUserInfo(UserInfo userInfo){
        return userService.getUserInfo(userInfo);
    }

    @PostMapping("/userLogout")
    public R logout(UserInfo userInfo){
        return userService.logout(userInfo);
    }
}
