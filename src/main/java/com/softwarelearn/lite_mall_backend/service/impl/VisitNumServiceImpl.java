package com.softwarelearn.lite_mall_backend.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.mapper.VisitNumInfoMapper;
import com.softwarelearn.lite_mall_backend.pojo.mall.VisitNumInfo;
import com.softwarelearn.lite_mall_backend.service.VisitNumService;
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
public class VisitNumServiceImpl extends ServiceImpl<VisitNumInfoMapper, VisitNumInfo> implements VisitNumService {
    @Autowired
    private VisitNumInfoMapper visitNumInfoMapper;

    @Override
    public R updateVisitNum(VisitNumInfo visitNumInfo) {
        LambdaQueryWrapper<VisitNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        // 1.去数据库查询访问量
        VisitNumInfo temp= visitNumInfoMapper.selectOne(queryWrapper);
        Integer views = temp.getVisitNum();
        // 2.拿出原来的量+1后更新到数据库
        views += 1;
        temp.setVisitNum(views);
        visitNumInfoMapper.updateById(temp);
        return R.success(ResultCode.VISITNUM_INCREASE_SUCCESS,null);
    }

    @Override
    public R getVisitNum(VisitNumInfo visitNumInfo) {
        LambdaQueryWrapper<VisitNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        // 1.去数据库查询订单量
        VisitNumInfo temp = visitNumInfoMapper.selectOne(queryWrapper);
        Integer views = temp.getVisitNum();
        return R.success(ResultCode.VISITNUM_SEARCH_SUCCESS, null);
    }
}