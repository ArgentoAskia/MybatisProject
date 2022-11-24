package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Film;
import cn.argentoaskia.enums.Rating;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmDAO {
    List<Film> selectAll();
    List<Film> selectByRating(@Param("rating") Rating rating);
}
