package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Country;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class CountryCityDAOTest {
    private SqlSession sqlSession;
    private CountryCityDAO mapper;

    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = CountryCityDAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(CountryCityDAO.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testMoreToMore(){
        List<Country> country = mapper.selectCountryAndItsCities();
        country.forEach(System.out::println);
    }

}
