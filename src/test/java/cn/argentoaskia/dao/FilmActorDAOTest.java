package cn.argentoaskia.dao;

import cn.argentoaskia.bean.FilmActor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class FilmActorDAOTest {

    private SqlSession sqlSession;
    private FilmActorDAO mapper;

    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = FilmActorDAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(FilmActorDAO.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testSelectFilmActorByFilmId(){
        List<FilmActor> filmActors = mapper.selectFilmActorByFilmId(1);
        filmActors.forEach(System.out::println);
    }
    @Test
    public void testSelectFilmActorByFilmId2(){
        List<FilmActor> filmActors = mapper.selectFilmActorByFilmId2(1);
        filmActors.forEach(System.out::println);
    }

    @Test
    public void testSelectFilmActorByFilmIdAndActorId(){
        FilmActor filmActors = mapper.selectFilmActorByFilmIdAndActorId(1, 1);
        System.out.println(filmActors);
    }
}
