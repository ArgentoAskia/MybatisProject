package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class CustomDAOTest {
    private SqlSession sqlSession;
    private CustomerDAO mapper;

    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = CustomerDAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(CustomerDAO.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testSelectByConditions(){
        Customer conditions = new Customer();
        conditions.setActive(1);
        List<Customer> customers = mapper.selectByConditions(conditions);
        for (Customer c :
                customers) {
            System.out.println(c);
        }
    }
}
