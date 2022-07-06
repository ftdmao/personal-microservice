package com.mjw.mq.consumer.business;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description :
 * @Date : 2022/7/5
 * @Author : jiawei_mao
 **/

@Component
public class EmailConsumer {

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue("email.queue"),exchange = @Exchange("test_direct")))
    public void consume(String message) {
        System.out.println("收到消息"+message);
    }

}
