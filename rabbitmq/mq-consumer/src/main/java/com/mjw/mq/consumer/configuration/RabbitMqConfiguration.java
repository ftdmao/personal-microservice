//package com.mjw.mq.consumer.configuration;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author whc
// * @date 2022/5/23 10:18
// */
//@Configuration
//public class RabbitMqConfiguration {
//
//    //1.声明注册fanout模式的交换机
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange("test_direct", true, false);
//    }
//
//    @Bean
//    public Queue emailQueue() {
//        return new Queue("email.queue", true);
//    }
//
//
//    @Bean
//    public Binding emailBind() {
//        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
//    }
//
//}