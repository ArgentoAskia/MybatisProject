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

/**
 * 基于XML的配置方式
 */
public class FilmTextDAOTest2 {

    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 通过XML的形式创建SqlSessionFactory
        InputStream mybatisConfig = FilmTextDAO2.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void close(){
        sqlSession.close();
    }


    @Test
    public void test_FilmTextDAO_SelectAll(){
        FilmTextDAO2 filmTextDAO = sqlSession.getMapper(FilmTextDAO2.class);
        List<FilmText> filmTexts = filmTextDAO.selectAll();
        for (FilmText f :
                filmTexts) {
            System.out.println(f);
        }
    }
}
