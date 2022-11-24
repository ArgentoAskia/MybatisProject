package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Film;

import java.util.List;

public interface FilmDAO {
    List<Film> selectAll();
}
