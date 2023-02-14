package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmTextOrigin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 基本CRUD,注解形式配置——DAO&Mapper
 */
public interface FilmTextDAOAnnotation {

    @Select("SELECT film_id, title, description FROM film_text")
    List<FilmTextOrigin> selectAll();

    @Select("SELECT film_id, title, description FROM film_text ft WHERE film_id = #{id}")
    FilmTextOrigin selectById(Integer id);

    @Insert("INSERT INTO film_text values(#{film_id}, #{title}, #{description})")
    Integer insert(FilmTextOrigin filmTextOrigin);

    @Update("UPDATE film_text SET title = #{title}, description = #{description} WHERE film_id = #{film_id}")
    Integer update(FilmTextOrigin filmTextOrigin);

    @Delete("DELETE FROM film_text WHERE film_id = #{film_id} AND title = #{title} AND description = #{description}")
    Integer delete(FilmTextOrigin filmTextOrigin);

    @Delete("DELETE FROM film_text WHERE film_id = #{id}")
    Integer delete2(Integer id);
}
