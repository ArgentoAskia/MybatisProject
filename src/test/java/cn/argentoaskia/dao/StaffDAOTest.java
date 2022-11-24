package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Film;
import cn.argentoaskia.bean.Staff;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class StaffDAOTest {
    private SqlSession sqlSession;
    private StaffDAO mapper;

    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = StaffDAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(StaffDAO.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void staffSelectAll(){
        List<Staff> staff = mapper.selectAll();
        staff.forEach(System.out::println);
    }

    @Test
    public void filmSelectAll(){
        FilmDAO mapper = sqlSession.getMapper(FilmDAO.class);
        List<Film> films = mapper.selectAll();
        films.forEach(System.out::println);
    }
}
