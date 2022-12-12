package cn.argentoaskia.dao;

import cn.argentoaskia.beans.Inventory;
import cn.argentoaskia.beans.type2.OriginInventory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class InventoryDAOTest {
    private SqlSession sqlSession;
    private InventoryDAO mapper;

    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = InventoryDAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(InventoryDAO.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }


    @Test
    public void testSelectByInventoryId(){
        Inventory inventory = mapper.selectByInventoryId(11);
        System.out.println(inventory);
    }
    @Test
    public void testSelectByInventoryId2(){
        OriginInventory originInventory = mapper.selectByInventoryId2(12);
        System.out.println(originInventory);
    }
}
