package cn.argentoaskia.dao;

import cn.argentoaskia.bean.FilmActor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmActorDAO {

    List<FilmActor> selectFilmActorByFilmId(@Param("id") Integer id);
    List<FilmActor> selectFilmActorByFilmId2(@Param("id") Integer id);

    FilmActor selectFilmActorByFilmIdAndActorId(@Param("filmId") Integer filmId,
                                                @Param("actorId") Integer actorId);

}
