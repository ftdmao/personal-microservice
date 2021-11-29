package com.mjw.service;

import com.mjw.domain.Order;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/23
 * @Author : jiawei_mao
 **/
public interface OrderService {
    /**
     * 创建订单
     *
     * @param order
     */
    void createOrder(Order order);

}
