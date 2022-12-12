package cn.argentoaskia.dao;

import cn.argentoaskia.beans.Inventory;
import org.apache.ibatis.annotations.Param;

public interface InventoryDAO {

    /**
     * 鉴别器相当于switch语句，除非必要否则一般不怎么用。
     * 要求当inventorId是奇数，则查询film，偶数则查询store
     * @param inventorId
     * @return
     */
    Inventory selectByInventoryId(@Param("inventorId") Integer inventorId);
}
