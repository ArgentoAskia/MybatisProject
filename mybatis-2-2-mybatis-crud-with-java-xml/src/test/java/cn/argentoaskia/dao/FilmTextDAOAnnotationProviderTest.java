package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmTextOrigin;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class FilmTextDAOAnnotationProviderTest {
    private SqlSession sqlSession;
    private FilmTextDAOAnnotationWithProvider mapper;
    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = FilmTextDAOXML.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(FilmTextDAOAnnotationWithProvider.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void fTestFileTextDAOXMLSelectAll(){
        System.out.println("----------> 1.FileTextDAOXMLSelectAll <----------");
        List<FilmTextOrigin> filmTextOrigins = mapper.selectAll();
        for (FilmTextOrigin fto :
                filmTextOrigins) {
            System.out.println(fto);
        }
        System.out.println("=================================================\n");
    }

    @Test
    public void eTestFileTextDAOXMLSelectById(){
        System.out.println("----------> 2.FileTextDAOXMLSelectById <----------");
        FilmTextOrigin filmTextOrigin = mapper.selectById(100);
        System.out.println(filmTextOrigin);
        System.out.println("=================================================\n");
    }
}
