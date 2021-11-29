package com.mjw.controller;

import com.mjw.domain.Order;
import com.mjw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/18
 * @Author : jiawei_mao
 **/
@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @PostMapping("/create")
    public String createOrder(@RequestBody Order order) {
        try {
            orderService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail：创建订单失败！";
        }
        return "success：创建订单成功！";
    }

}
