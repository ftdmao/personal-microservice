package com.mjw.service.impl;

import com.mjw.domain.Order;
import com.mjw.mapper.OrderMapper;
import com.mjw.service.AccountService;
import com.mjw.service.OrderService;
import com.mjw.service.StorageService;
import com.mjw.tcc.OrderTccAction;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/23
 * @Author : jiawei_mao
 **/
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderTccAction orderTccAction;

    @Reference(version = "1.0.0")
    StorageService storageService;

    @Reference(version = "1.0.0")
    AccountService accountService;


    @Override
    @GlobalTransactional
    public void createOrder(Order order) {
        String orderNo = this.generateOrderNo();
        //创建订单
        orderTccAction.prepareCreateOrder(null,
                orderNo,
                order.getUserId(),
                order.getProductId(),
                order.getAmount(),
                order.getMoney());
        //扣余额
        accountService.decreaseMoney(order.getUserId(),order.getMoney());
        //扣库存
        storageService.decreaseStorage(order.getProductId(),order.getAmount());

    }


    private String generateOrderNo() {
        return LocalDateTime.now()
                .format(
                        DateTimeFormatter.ofPattern("yyMMddHHmmssSSS")
                );
    }
}
