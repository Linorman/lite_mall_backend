package com.softwarelearn.lite_mall_backend.controller.user;

import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.pojo.user.UserInfo;
import com.softwarelearn.lite_mall_backend.constant.JwtResponse;
import com.softwarelearn.lite_mall_backend.security.JwtTokenUtil;
import com.softwarelearn.lite_mall_backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制器
 *
 * @author linorman
 * @data 2023/04/16
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public R register(@RequestBody UserInfo userInfo) {
        return userService.register(userInfo);
    }

//    @PostMapping("/userSignIn")
//    public R signIn(@RequestBody UserInfo userInfo){
//        return userService.signIn(userInfo);
//    }
//
//    @PostMapping("/getUserInfo")
//    public R getUserInfo(@RequestBody UserInfo userInfo){
//        return userService.getUserInfo(userInfo);
//    }
//
//    @PostMapping("/userLogout")
//    public R logout(@RequestBody UserInfo userInfo){
//        return userService.logout(userInfo);
//    }

    @PostMapping("/userSignIn")
    public R signIn(@RequestBody UserInfo userInfo) {
        final UserDetails userDetails = userService.loadUserByUsername(userInfo.getUsername());
        if (userDetails == null) {
            return R.error(ResultCode.USER_NOT_EXISTS, null);
        }
        if (!userDetails.getPassword().equals(userInfo.getPassword())) {
            return R.error(ResultCode.USER_PASSWORD_WRONG, null);
        }
        final String token = jwtTokenUtil.generateToken(userDetails);
        return R.success(ResultCode.SUCCESS, new JwtResponse(token));
    }

    @PostMapping("/getUserInfo")
    public R getUserInfo(HttpServletRequest request) {
        final String token = request.getHeader("Authorization");
        final String username = jwtTokenUtil.getUsernameFromToken(token);
        final UserDetails userDetails = userService.loadUserByUsername(username);
        if (userDetails == null) {
            return R.error(ResultCode.USER_NOT_LOGIN, null);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        return userService.getUserInfo(userInfo);
    }

    @PostMapping("/userLogout")
    public R logout(HttpServletRequest request) {
        final String token = request.getHeader("Authorization");
        final String username = jwtTokenUtil.getUsernameFromToken(token);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        return userService.logout(userInfo);
    }
}
