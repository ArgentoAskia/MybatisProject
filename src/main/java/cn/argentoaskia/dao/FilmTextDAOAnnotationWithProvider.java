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

    @InsertProvider(type = FilmTextDAOProvider2.class, method = "insert")
    Integer insert(FilmTextOrigin filmTextOrigin);

    @UpdateProvider(value = FilmTextDAOProvider2.class, method = "update")
    Integer update(FilmTextOrigin filmTextOrigin);

    @DeleteProvider(FilmTextDAOProvider.class)
    Integer delete(FilmTextOrigin filmTextOrigin);

    @DeleteProvider(FilmTextDAOProvider.class)
    Integer delete2(Integer id);
}
