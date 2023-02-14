package cn.argentoaskia.dao2;

import cn.argentoaskia.beans.FilmInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * FilmInfo-ResultMap实现表级联查询
 */
public interface FilmInfoDAO {

    @Results(
            id = "filmInfo",
            value =
            {
                    @Result(column = "film_id", property = "filmId", id = true),
                    @Result(column = "title", property = "filmTitle"),
                    @Result(column = "description", property = "filmDesc"),
                    @Result(column = "first_name", property = "filmActorFirstName"),
                    @Result(column = "last_name", property = "filmActorLastName")
            }
    )
    @Select("SELECT ft.film_id, ft.title, ft.description, a.first_name, a.last_name\n" +
            "        FROM film_text ft JOIN film_actor fa on ft.film_id = fa.film_id\n" +
            "                          JOIN actor a on a.actor_id = fa.actor_id")
    List<FilmInfo> selectAll();

    @Select(" SELECT ft.film_id AS filmId,\n" +
            "        ft.title AS filmTitle,\n" +
            "        ft.description AS filmDesc,\n" +
            "        a.first_name AS filmActorFirstName,\n" +
            "        a.last_name AS filmActorLastName\n" +
            "        FROM film_text ft JOIN film_actor fa on ft.film_id = fa.film_id\n" +
            "                          JOIN actor a on a.actor_id = fa.actor_id")
    List<FilmInfo> selectAll2();
}
