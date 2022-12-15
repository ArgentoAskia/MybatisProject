package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Actor;
import cn.argentoaskia.bean.Category;
import cn.argentoaskia.config.MybatisSpringConfigType1;
import cn.argentoaskia.config.MybatisSpringConfigType2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MybatisSpringConfigType2.class})
public class SpringDAOJavaConfigType2Test {

    @Autowired
    private ActorDAO actorDAO;


    @Test
    public void testActorDAO(){
        System.out.println(actorDAO);
        List<Actor> actors = actorDAO.selectAll();
        actors.forEach(System.out::println);
    }

    @Autowired
    private CategoryDAO categoryDAO;


    @Test
    public void testCategoryDAO(){
        System.out.println(categoryDAO);
        List<Category> categories = categoryDAO.selectAll();
        categories.forEach(System.out::println);
    }
}
