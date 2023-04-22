package com.softwarelearn.lite_mall_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.mall.OrderNumInfo;


/**
 * 订单量接口
 * @author ww
 * @data 2023/04/22
 */

public interface OrderNumService extends IService<OrderNumInfo> {
    /**
     * 订单量加一
     * @param orderNumInfo
     * @return R
     */
    public R updateOrderNum(OrderNumInfo orderNumInfo);
    public R getOrderNum(OrderNumInfo orderNumInfo);
}
