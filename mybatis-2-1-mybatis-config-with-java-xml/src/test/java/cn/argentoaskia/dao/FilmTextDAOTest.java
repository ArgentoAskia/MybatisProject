package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmText;
import cn.argentoaskia.mybatis.MybatisConfig;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 通过代码的形式创建Mybatis-config
 */
public class FilmTextDAOTest {

    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 通过代码的形式创建Mybatis-config
        MybatisConfig mybatisConfig = new MybatisConfig();
//        mybatisConfig.registerMappers(FilmTextDAO2.class);
        String resource = "cn/argentoaskia/dao/FilmTextDAO2.xml";
        mybatisConfig.registerMappers(resource);
        Configuration configuration = mybatisConfig.getConfiguration();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(configuration);
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
