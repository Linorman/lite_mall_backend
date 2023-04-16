package com.softwarelearn.lite_mall_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.user.UserInfo;

/**
 * 用户服务接口
 * @author linorman
 * @data 2023/04/16
 */
public interface UserService extends IService<UserInfo> {
    /**
     * 用户注册
     * @param userInfo
     * @return R
     */
    public R register(UserInfo userInfo);
}
