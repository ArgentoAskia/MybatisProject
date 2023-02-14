package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Actor;

import java.util.List;

public interface ActorDAO {

    List<Actor> selectBySingleConditions(Actor actor);
}
