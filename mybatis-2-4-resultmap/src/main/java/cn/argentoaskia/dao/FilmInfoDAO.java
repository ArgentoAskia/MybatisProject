package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmInfo;

import java.util.List;

/**
 * FilmInfo-ResultMap实现表级联查询
 */
public interface FilmInfoDAO {
    List<FilmInfo> selectAll();
    List<FilmInfo> selectAll2();
}
