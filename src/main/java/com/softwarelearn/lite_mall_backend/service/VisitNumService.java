package com.softwarelearn.lite_mall_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.mall.VisitNumInfo;

/**
 * 访问量接口
 * @author ww
 * @data 2023/04/22
 */

public interface VisitNumService extends IService<VisitNumInfo> {
    /**
     * 访问量量加一
     * @param visitNumInfo
     * @return R
     */
    public R updateVisitNum(VisitNumInfo visitNumInfo);
    public R getVisitNum(VisitNumInfo visitNumInfo);
}