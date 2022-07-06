package com.mjw.mq.producer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description :
 * @Date : 2022/7/5
 * @Author : jiawei_mao
 **/
@RestController
@RequestMapping(value = "order")
public class TestController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/create")
    public void testSome() {
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功：" + orderId);
        String exchange_name = "test_direct";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchange_name, routingKey, orderId);


    }

}
