package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmTextOrigin;

import java.util.List;

/**
 * 基本CRUD,XML形式配置——DAO
 */
public interface FilmTextDAOXML {
    List<FilmTextOrigin> selectAll();
    FilmTextOrigin selectById(Integer id);
    Integer insert(FilmTextOrigin filmTextOrigin);
    Integer update(FilmTextOrigin filmTextOrigin);
    Integer delete(FilmTextOrigin filmTextOrigin);
    Integer delete2(Integer id);
}
