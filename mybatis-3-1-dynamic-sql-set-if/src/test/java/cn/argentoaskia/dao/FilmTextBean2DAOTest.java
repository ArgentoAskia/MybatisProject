package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmTextBean2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class FilmTextBean2DAOTest {
    private SqlSession sqlSession;
    private FilmTextBean2DAO mapper;

    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = FilmTextBean2DAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(FilmTextBean2DAO.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testDynamicUpdate(){
        FilmTextBean2 filmTextBean2 = new FilmTextBean2();
        filmTextBean2.setFilmId(1000)
                .setFilmTitle("test");
        Integer update = mapper.update(filmTextBean2);
        System.out.println(update);
    }
}
