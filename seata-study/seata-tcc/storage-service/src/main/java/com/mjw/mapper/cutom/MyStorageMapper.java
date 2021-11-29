package com.mjw.mapper.cutom;

import com.mjw.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Module : 繁殖云--XX应用--XX模块--XX单据
 * @Description :
 * @Date : 2021/11/24
 * @Author : jiawei_mao
 **/
public interface MyStorageMapper {


    /**
     * 冻结库存
     *
     * @param productId
     * @param residue
     * @param frozen
     */
    void updateFrozen(@Param("productId") Integer productId, @Param("residue") Integer residue, @Param("frozen") Integer frozen);

    /**
     * 提交时，把冻结量修改到已售出
     *
     * @param productId
     * @param count
     */
    void updateFrozenToUsed(@Param("productId") Long productId, @Param("count") Integer count);

    /**
     * 回滚时，把冻结量修改到可用库存
     *
     * @param productId
     * @param count
     */
    void updateFrozenToResidue(@Param("productId") Long productId, @Param("count") Integer count);

}
