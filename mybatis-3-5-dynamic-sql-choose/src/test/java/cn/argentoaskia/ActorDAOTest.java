package cn.argentoaskia;

import cn.argentoaskia.bean.Actor;
import cn.argentoaskia.dao.ActorDAO;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ActorDAOTest {

    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = ActorDAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig, "dev");
        sqlSession = sqlSessionFactory.openSession();
        mybatisConfig.close();
    }

    @After
    public void close(){
        sqlSession.close();
    }


    @Test
    public void test_SelectBySingleConditions(){
        ActorDAO filmTextDAO = sqlSession.getMapper(ActorDAO.class);
        Actor actor = new Actor().setFirstName("%P%").setLastName("%G%");
        List<Actor> Actors = filmTextDAO.selectBySingleConditions(actor);
        for (Actor a :
                Actors) {
            System.out.println(a);
        }
    }


}
