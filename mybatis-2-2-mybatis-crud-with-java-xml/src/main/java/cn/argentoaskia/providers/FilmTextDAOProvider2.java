package cn.argentoaskia.providers;

import cn.argentoaskia.beans.FilmTextOrigin;
import org.apache.ibatis.jdbc.SQL;

/**
 * 不实现 ProviderMethodResolver接口的写法
 */
public class FilmTextDAOProvider2 {

    // SELECT film_id, title, description FROM film_text
    public String selectAll() {
        return new SQL(){
            {
                SELECT("film_id", "title", "description");
                FROM("film_text");
            }
        }.toString();
    }

    // SELECT film_id, title, description FROM film_text ft WHERE film_id = #{id}
    public String selectById(Integer id) {
        return new SQL(){
            {
                SELECT("film_id", "title", "description");
                FROM("film_text");
                WHERE("film_id = #{id}");
            }
        }.toString();
    }

    // INSERT INTO film_text values(#{film_id}, #{title}, #{description})
    public String insert(FilmTextOrigin filmTextOrigin) {
        return new SQL(){
            {
                INSERT_INTO("film_text");
                INTO_VALUES("#{film_id}", "#{title}", "#{description}");
            }
        }.toString();
    }

    // UPDATE film_text SET title = #{title}, description = #{description} WHERE film_id = #{film_id}
    public String update(FilmTextOrigin filmTextOrigin) {
        return new SQL(){
            {
                UPDATE("film_text");
                SET("title = #{title}", "description = #{description}");
                WHERE("film_id = #{film_id}");
            }
        }.toString();
    }

    // DELETE FROM film_text WHERE film_id = #{film_id} AND title = #{title} AND description = #{description}
    public String delete(FilmTextOrigin filmTextOrigin) {
        return new SQL(){
            {
                DELETE_FROM("film_text");
                WHERE("film_id = #{film_id}").AND();
                WHERE("title = #{title}").AND();
                WHERE("description = #{description}");
            }
        }.toString();
    }

    // DELETE FROM film_text WHERE film_id = #{id}
    public String delete2(Integer id) {
        return new SQL(){
            {
                DELETE_FROM("film_text");
                WHERE("film_id = #{id}");
            }
        }.toString();
    }
}
