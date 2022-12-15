package cn.argentoaskia.dao;


import cn.argentoaskia.bean.Actor;
import cn.argentoaskia.bean.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-dao-support.xml")
public class SpringDAOSupportTest {

    @Autowired
    private ActorDAO actorDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Test
    public void testActorDAO(){
        // ActorDAOSupport
        System.out.println(actorDAO);
        List<Actor> actors = actorDAO.selectAll();
        actors.forEach(System.out::println);
    }
    @Test
    public void testCategoryDAO(){
        // CategoryDAOSupport
        System.out.println(categoryDAO);
        List<Category> categories = categoryDAO.selectAll();
        categories.forEach(System.out::println);
    }
}
