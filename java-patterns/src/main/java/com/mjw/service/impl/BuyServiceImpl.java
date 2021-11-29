package com.mjw.service.impl;

import com.mjw.service.BuyService;
import com.mjw.strategy.Pay;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/28
 * @Author : jiawei_mao
 **/
@Service
public class BuyServiceImpl implements BuyService {

    private Map<String, Pay> payMap = new HashMap<>();

    public BuyServiceImpl(List<Pay> payList) {
        for (Pay pay : payList) {
            payMap.put(pay.getType(), pay);
        }
    }


    @Override
    public void buySomething(double money, String payType) {
        Pay pay = payMap.get(payType);
        pay.pay(money);
    }
}
