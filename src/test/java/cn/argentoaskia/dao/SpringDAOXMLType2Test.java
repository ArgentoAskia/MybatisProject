package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Actor;
import cn.argentoaskia.bean.Category;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-dao-2.xml")
public class SpringDAOXMLType2Test {

    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void testActorDAO(){
        ActorDAO actorDAO = sqlSession.getMapper(ActorDAO.class);
        System.out.println(actorDAO);
        List<Actor> actors = actorDAO.selectAll();
        actors.forEach(System.out::println);
    }
    @Test
    public void testCategoryDAO(){
        CategoryDAO categoryDAO = sqlSessionTemplate.getMapper(CategoryDAO.class);
        System.out.println(categoryDAO);
        List<Category> categories = categoryDAO.selectAll();
        categories.forEach(System.out::println);
    }


}
