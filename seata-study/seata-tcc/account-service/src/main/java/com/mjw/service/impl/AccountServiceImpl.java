package com.mjw.service.impl;

import com.mjw.service.AccountService;
import com.mjw.tcc.AccountTccAction;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/24
 * @Author : jiawei_mao
 **/
@Service(version = "1.0.0")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountTccAction accountTccAction;

    @Override
    public void decreaseMoney(Integer userId, BigDecimal money) {
        accountTccAction.prepareDecreaseMoney(null, userId, money);
    }

}
