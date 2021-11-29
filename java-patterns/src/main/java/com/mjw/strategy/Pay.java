package com.mjw.strategy;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/28
 * @Author : jiawei_mao
 **/
public interface Pay {

    String getType();

    void pay(double money);

}
