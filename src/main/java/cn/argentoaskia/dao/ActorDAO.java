package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Actor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
// 下面的Mapper注解在Spring-mybatis里面理论上不会发挥作用，因为这个注解是留给SpringBoot的，但是为了保持习惯，还是加上
@Mapper
public interface ActorDAO {

    List<Actor> selectAll();
    List<Actor> selectById(Integer id);
}
