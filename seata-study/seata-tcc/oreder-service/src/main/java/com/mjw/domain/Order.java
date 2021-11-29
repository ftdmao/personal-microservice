package com.mjw.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/18
 * @Author : jiawei_mao
 **/
@Data
@Table(name = "myorder")
public class Order implements Serializable {
    private static final long serialVersionUID = -6214357858300135802L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "status")
    private Integer status;


    public Order() {
    }

    public Order(String orderNo, Integer userId, Integer productId, Integer amount, BigDecimal money, Integer status) {
        this.orderNo = orderNo;
        this.userId = userId;
        this.productId = productId;
        this.amount = amount;
        this.money = money;
        this.status = status;
    }
}
