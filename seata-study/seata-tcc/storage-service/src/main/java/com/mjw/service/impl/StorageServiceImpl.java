package com.mjw.service.impl;

import com.mjw.mapper.BaseMapper;
import com.mjw.service.StorageService;
import com.mjw.tcc.StorageTccAction;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/23
 * @Author : jiawei_mao
 **/
@Service(version = "1.0.0")
public class StorageServiceImpl implements StorageService {

    @Autowired
    BaseMapper storageMapper;

    @Autowired
    StorageTccAction storageTccAction;

    /**
     * 扣库存
     *
     * @param productId
     * @param count
     * @return
     */
    @Override
    public void decreaseStorage(Integer productId, Integer count) {
        storageTccAction.prepareDecreaseStorage(null, productId, count);
    }
}
