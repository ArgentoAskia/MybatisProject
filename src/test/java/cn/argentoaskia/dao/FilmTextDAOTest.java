package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmText;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FilmTextDAOTest {

    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = FilmTextDAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig, "dev");
        sqlSession = sqlSessionFactory.openSession();
        mybatisConfig.close();
    }

    @After
    public void close(){
        sqlSession.close();
    }


    @Test
    public void test_FilmTextDAO_SelectAll(){
        FilmTextDAO filmTextDAO = sqlSession.getMapper(FilmTextDAO.class);
        List<FilmText> filmTexts = filmTextDAO.selectAll();
        for (FilmText f :
                filmTexts) {
            System.out.println(f);
        }
    }
}
