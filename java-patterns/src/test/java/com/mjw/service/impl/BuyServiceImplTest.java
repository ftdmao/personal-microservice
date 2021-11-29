package com.mjw.service.impl;

import com.mjw.JavaPatternApplication;
import com.mjw.service.BuyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/28
 * @Author : jiawei_mao
 **/
@SpringBootTest(classes = JavaPatternApplication.class)
@RunWith(SpringRunner.class)
public class BuyServiceImplTest {

    @Autowired
    BuyService buyService;

    @Test
    public void testBuy(){
        buyService.buySomething(1.55,"WeChat");
    }

    @Test
    public void buySomething() {
    }
}