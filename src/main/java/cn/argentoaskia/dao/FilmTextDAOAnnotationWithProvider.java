package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmTextOrigin;
import cn.argentoaskia.providers.*;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface FilmTextDAOAnnotationWithProvider {

    @SelectProvider(FilmTextDAOProvider.class)
    List<FilmTextOrigin> selectAll();

    @SelectProvider(type = FilmTextDAOProvider2.class, method = "selectById")
    FilmTextOrigin selectById(Integer id);

    @SelectProvider(type = FilmTextDAOProvider2.class, method = "insert")
    Integer insert(FilmTextOrigin filmTextOrigin);

    @SelectProvider(value = FilmTextDAOProvider2.class, method = "update")
    Integer update(FilmTextOrigin filmTextOrigin);

    @SelectProvider(FilmTextDAOProvider.class)
    Integer delete(FilmTextOrigin filmTextOrigin);

    @SelectProvider(FilmTextDAOProvider.class)
    Integer delete2(Integer id);
}
