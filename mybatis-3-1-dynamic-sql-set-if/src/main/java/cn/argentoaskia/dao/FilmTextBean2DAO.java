package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmTextBean2;

import java.util.List;

public interface FilmTextBean2DAO {

    /**
     * set标签实现动态更新内容
     * @param filmTextBean2
     * @return
     */
    Integer update(FilmTextBean2 filmTextBean2);
}
