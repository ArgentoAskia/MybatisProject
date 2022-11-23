package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmTextBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class FilmTextDAOResultMapTest {

    private SqlSession sqlSession;
    private FilmTextDAOResultMap mapper;
    private cn.argentoaskia.dao2.FilmTextDAOResultMap mapper2;
    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = FilmTextDAOResultMap.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(FilmTextDAOResultMap.class);
        mapper2 = sqlSession.getMapper(cn.argentoaskia.dao2.FilmTextDAOResultMap.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testFilmTextDAOSelectAll1WithXML(){
        List<FilmTextBean> filmTextBeans = mapper.selectAll1();
        for (FilmTextBean f :
                filmTextBeans) {
            System.out.println(f);
        }
    }

    @Test
    public void testFilmTextDAOSelectAll2WithXML(){
        List<FilmTextBean> filmTextBeans = mapper.selectAll2();
        for (FilmTextBean f :
                filmTextBeans) {
            System.out.println(f);
        }
    }

    // 测试@Results+SQL语句
    @Test
    public void testFilmTextDAOSelectAll1WithAnnotation(){
        List<FilmTextBean> filmTextBeans = mapper2.selectAll1();
        for (FilmTextBean f :
                filmTextBeans) {
            System.out.println(f);
        }
    }

    // 测试@ResultType+SQl语句AS起别名的方式
    @Test
    public void testFilmTextDAOSelectAll2WithAnnotation(){
        List<FilmTextBean> filmTextBeans = mapper2.selectAll2();
        for (FilmTextBean f :
                filmTextBeans) {
            System.out.println(f);
        }
    }

    // 测试@ResultMap
    @Test
    public void testFilmTextDAOSelectAll3WithAnnotation(){
        FilmTextBean filmTextBean = mapper2.selectByFilmId(50);
        System.out.println(filmTextBean);
    }
}
