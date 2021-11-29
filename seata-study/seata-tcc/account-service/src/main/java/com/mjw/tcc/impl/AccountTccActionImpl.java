package com.mjw.tcc.impl;

import com.mjw.domain.Account;
import com.mjw.mapper.AccountMapper;
import com.mjw.tcc.AccountTccAction;
import com.mjw.utils.ResultHolder;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @description:
 * @date: 2021/2/11 10:04 上午
 * @author: kerry
 */
@Slf4j
@Component
public class AccountTccActionImpl implements AccountTccAction {


    @Autowired
    AccountMapper accountMapper;


    /**
     * try 尝试
     *
     * @param businessActionContext
     * @param userId
     * @param money
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean prepareDecreaseMoney(BusinessActionContext businessActionContext, Integer userId, BigDecimal money) {
        log.info("减少账户金额，第一阶段锁定金额，userId=" + userId + "， money=" + money);
        Account account = accountMapper.findOneByUserId(userId);
        //余额不足，处理
        if (account.getResidue().compareTo(money) < 0) {
            throw new RuntimeException("账户金额不足");
        }
        //冻结钱
        accountMapper.updateFrozen(userId, account.getResidue().subtract(money), account.getFrozen().add(money));
        ResultHolder.setResult(getClass(), businessActionContext.getXid(), "p");
        return true;
    }

    /**
     * commit 提交
     *
     * @param businessActionContext
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean commit(BusinessActionContext businessActionContext) {
        Integer userId = Integer.parseInt(businessActionContext.getActionContext("userId").toString());
        BigDecimal money = new BigDecimal(businessActionContext.getActionContext("money").toString());
        log.info("减少账户金额，第二阶段，提交，userId=" + userId + "， money=" + money);

        //防止重复提交
        if (ResultHolder.getResult(getClass(), businessActionContext.getXid()) == null) {
            return true;
        }
        accountMapper.updateFrozenToUsed(userId, money);
        //删除标识
        ResultHolder.removeResult(getClass(), businessActionContext.getXid());
        return true;
    }

    /**
     * cancel 撤销
     *
     * @param businessActionContext
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {
        Integer userId = Integer.parseInt(businessActionContext.getActionContext("userId").toString());
        BigDecimal money = new BigDecimal(businessActionContext.getActionContext("money").toString());

        //防止重复回滚
        if (ResultHolder.getResult(getClass(), businessActionContext.getXid()) == null) {
            return true;
        }
        log.info("减少账户金额，第二阶段，回滚，userId=" + userId + "， money=" + money);
        accountMapper.updateFrozenToResidue(userId, money);
        //删除标识
        ResultHolder.removeResult(getClass(), businessActionContext.getXid());
        return true;
    }
}
