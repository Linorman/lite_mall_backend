package com.softwarelearn.lite_mall_backend.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.mapper.OrderNumInfoMapper;
import com.softwarelearn.lite_mall_backend.pojo.mall.OrderNumInfo;
import com.softwarelearn.lite_mall_backend.service.OrderNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 * @author ww
 * @data 2023/04/22
 */
@Slf4j
@Service
@DS("visit_order_info")
public class OrderNumServiceImpl extends ServiceImpl<OrderNumInfoMapper, OrderNumInfo> implements OrderNumService {
    @Autowired
    private OrderNumInfoMapper orderNumInfoMapper;

    @Override
    public R updateOrderNum(OrderNumInfo orderNumInfo) {
        LambdaQueryWrapper<OrderNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        OrderNumInfo temp= orderNumInfoMapper.selectOne(queryWrapper);
        Integer views = temp.getOrderNum();
        if (views.equals(null)) {views=1;}
        else{views += 1;}
        temp.setOrderNum(views);
        orderNumInfoMapper.updateById(temp);
        return R.success(ResultCode.ORDERNUM_INCREASE_SUCCESS,null);
    }

    @Override
    public R getOrderNum(OrderNumInfo orderNumInfo) {
        LambdaQueryWrapper<OrderNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        OrderNumInfo temp = orderNumInfoMapper.selectOne(queryWrapper);
        int views = temp.getOrderNum();
        return R.success(ResultCode.ORDERNUM_SEARCH_SUCCESS, views);
    }
}
