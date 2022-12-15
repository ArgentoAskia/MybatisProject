package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Actor;
import cn.argentoaskia.bean.Category;
import cn.argentoaskia.config.MybatisSpringConfigType2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-dao-1.xml")
public class SpringDAOXMLType1Test {

    // 参考Spring官网1.8.3点实现，FactoryBean实现
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;
    @Autowired
    private ActorDAO actorDAO;
    @Autowired
    private CategoryDAO categoryDAO;


    @Test
    public void testActorDAO(){
        System.out.println(actorDAO);
        List<Actor> actors = actorDAO.selectAll();
        actors.forEach(System.out::println);
    }
    @Test
    public void testCategoryDAO(){
        System.out.println(categoryDAO);
        List<Category> categories = categoryDAO.selectAll();
        categories.forEach(System.out::println);
    }
}
