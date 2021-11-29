package com.mjw.service;


/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/23
 * @Author : jiawei_mao
 **/
public interface StorageService {

    /**
     * 扣库存
     * @param productId
     * @param count
     * @return
     */
    void decreaseStorage(Integer productId, Integer count);

}
