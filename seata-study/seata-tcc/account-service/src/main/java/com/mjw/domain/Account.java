package com.mjw.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description:
 * @date: 2021/2/13 10:25 下午
 * @author: kerry
 */
@Data
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;
    /**
     * 剩余可用额度
     */
    @Column(name = "residue")
    private BigDecimal residue;
    /**
     * TCC事务锁定的金额
     */
    @Column(name = "frozen")
    private BigDecimal frozen;
}
