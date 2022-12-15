package cn.argentoaskia.dao.support;

import cn.argentoaskia.bean.Actor;
import cn.argentoaskia.dao.ActorDAO;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class ActorDAOSupport extends SqlSessionDaoSupport implements ActorDAO {
    @Override
    public List<Actor> selectAll() {
        ActorDAO mapper = getSqlSession().getMapper(ActorDAO.class);
        return mapper.selectAll();
    }

    @Override
    public List<Actor> selectById(Integer id) {
        return null;
    }
}
