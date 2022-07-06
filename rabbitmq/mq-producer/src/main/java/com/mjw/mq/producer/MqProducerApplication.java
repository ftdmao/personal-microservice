package com.mjw.mq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackageClasses = {MqProducerApplication.class})
public class MqProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqProducerApplication.class, args);
    }

}
