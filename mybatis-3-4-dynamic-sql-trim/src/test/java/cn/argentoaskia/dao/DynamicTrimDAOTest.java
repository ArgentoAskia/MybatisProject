package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Customer2;
import cn.argentoaskia.bean.FilmTextBean3;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class DynamicTrimDAOTest {
    private SqlSession sqlSession;
    private DynamicTrimDAO mapper;

    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = DynamicTrimDAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(DynamicTrimDAO.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testDynamicUpdate(){
        FilmTextBean3 filmTextBean3 = new FilmTextBean3();
        filmTextBean3.setFilmId(1000)
                .setFilmTitle("test");
        Integer update = mapper.update(filmTextBean3);
        System.out.println(update);
    }

    @Test
    public void testSelectByConditions(){
        Customer2 conditions = new Customer2();
        conditions.setActive(1);
        List<Customer2> customers = mapper.selectByConditions(conditions);
        for (Customer2 c :
                customers) {
            System.out.println(c);
        }
    }
}
