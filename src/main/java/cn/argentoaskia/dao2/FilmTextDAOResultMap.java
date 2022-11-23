package cn.argentoaskia.dao2;

import cn.argentoaskia.beans.FilmTextBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 基于注解的形式的ResultMap配置
 */
public interface FilmTextDAOResultMap {

    /**
     * 定义ResultMap同时使用
     * @return
     */
    @Results(
            id = "filmText",
            value = {
                    @Result(property = "filmId", column = "film_id", id = true),
                    @Result(property = "filmTitle", column = "title"),
                    @Result(property = "filmDesc", column = "description")
            }
    )
    @Select("SELECT film_id, title, description\n" +
            "        FROM film_text")
    List<FilmTextBean> selectAll1();

    /**
     * 如果不想用ResultMap，采用命名的方式可以使用@ResultType
     * @return
     */
    @ResultType(FilmTextBean.class)
    @Select(" SELECT film_id AS filmId, title AS filmTitle, description AS filmDesc\n" +
            "        FROM film_text")
    List<FilmTextBean> selectAll2();

    /**
     * 采用ResultMap的方式来写
     * @param filmId
     * @return
     */
    @Select("SELECT film_id, title, description\n" +
            "FROM film_text\n" +
            "WHERE film_id = #{filmId}")
    @ResultMap("filmText")
    FilmTextBean selectByFilmId(@Param("filmId") Integer filmId);
}
