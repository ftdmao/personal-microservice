package com.mjw.strategy;

import org.springframework.stereotype.Component;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/28
 * @Author : jiawei_mao
 **/
@Component
public class QQPay implements Pay {

    @Override
    public String getType() {
        return "QQ";
    }

    @Override
    public void pay(double money) {
        double discount = 1.0;
        double realMoney = money * discount;
        System.out.println(realMoney);
    }

}
