package com.softwarelearn.lite_mall_backend.pojo.mall;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 在线用户信息类
 * @author linorman
 * @data 2023/05/08
 */
@Slf4j
@Data
@TableName("online_user_info")
public class OnlineUserNumInfo implements Serializable {
    private Long id;
    private Integer onlineUserNum;
}
