package com.mjw.tcc.impl;

import com.mjw.domain.Order;
import com.mjw.mapper.OrderMapper;
import com.mjw.tcc.OrderTccAction;
import com.mjw.utils.ResultHolder;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/19
 * @Author : jiawei_mao
 **/
@Component
public class OrderTccActionImpl implements OrderTccAction {


    @Autowired
    OrderMapper orderMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean prepareCreateOrder(BusinessActionContext businessActionContext,
                                      String orderNo,
                                      Integer userId,
                                      Integer productId,
                                      Integer amount,
                                      BigDecimal money) {
        Order order = new Order(orderNo, userId, productId, amount, money, 0);
        orderMapper.insert(order);
        ResultHolder.setResult(OrderTccAction.class, businessActionContext.getXid(), "p");
        return true;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean commit(BusinessActionContext businessActionContext) {
        //检查标记是否存在，如果标记不存在不重复提交
        String p = ResultHolder.getResult(OrderTccAction.class, businessActionContext.getXid());
        if (p == null) {
            return true;
        }
        /**
         * 上下文对象从第一阶段向第二阶段传递时，先转成了json数据，然后还原成上下文对象
         * 其中的整数比较小的会转成Integer类型，所以如果需要Long类型，需要先转换成字符串在用Long.valueOf()解析。
         */
        String orderNo = businessActionContext.getActionContext("orderNo").toString();
        Example example = buildOrderNoExample(orderNo);
        Order order = new Order();
        order.setStatus(1);
        orderMapper.updateByExampleSelective(order, example);
        //提交完成后，删除标记
        ResultHolder.removeResult(OrderTccAction.class, businessActionContext.getXid());
        return true;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean rollback(BusinessActionContext businessActionContext) {
        //检查标记是否存在，如果标记不存在不重复提交
        String p = ResultHolder.getResult(OrderTccAction.class, businessActionContext.getXid());
        if (p == null) {
            return true;
        }
        String orderNo = businessActionContext.getActionContext("orderNo").toString();
        Example example = buildOrderNoExample(orderNo);
        orderMapper.deleteByExample(example);
        //提交完成后，删除标记
        ResultHolder.removeResult(OrderTccAction.class, businessActionContext.getXid());
        return true;
    }

    private Example buildOrderNoExample(String orderNo) {
        Example example = new Example(Order.class);
        example.createCriteria().andEqualTo("orderNo", orderNo);
        return example;
    }
}
