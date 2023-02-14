package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Customer2;
import cn.argentoaskia.bean.FilmTextBean3;

import java.util.List;

public interface DynamicTrimDAO {

    /**
     * 使用trim标签实现where标签功能
     * @param customer
     * @return
     */
    List<Customer2> selectByConditions(Customer2 customer);

    /**
     * 使用trim标签实现set标签功能
     * @param filmTextBean3
     * @return
     */
    Integer update(FilmTextBean3 filmTextBean3);
}
