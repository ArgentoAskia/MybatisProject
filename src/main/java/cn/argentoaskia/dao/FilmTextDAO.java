package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmText;

import java.util.List;

// 2.编写dao接口
public interface FilmTextDAO {

    List<FilmText> selectAll();
}
