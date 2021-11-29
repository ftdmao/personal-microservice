package com.mjw.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/23
 * @Author : jiawei_mao
 **/
@Data
@Table
public class Storage implements Serializable {

    private static final long serialVersionUID = 1772555393433637279L;
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    /**
     * 余额
     */
    @Column(name = "residue")
    private Integer residue;

    /**
     * 冻结
     */
    @Column(name = "frozen")
    private Integer frozen;

    public Storage() {
    }

    public Storage(Integer productId, Integer residue, Integer frozen) {
        this.productId = productId;
        this.residue = residue;
        this.frozen = frozen;
    }
}
