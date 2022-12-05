package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Actor;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.session.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class PageSelectDAOTest {
    private SqlSession sqlSession;
    private PageSelectDAO mapper;

    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = PageSelectDAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(PageSelectDAO.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    /**
     * 基于业务层的分页写法，下面的代码都应写在业务层
     */
    @Test
    public void testSelectPageByService(){
        // 模拟分页参数
        int page = 2;
        int limit = 10;
        // 1.先获取所有数据
        List<Actor> actors = mapper.selectPageByService();
        // 2.通过page计算begin，如对于上面的分页参数，实际上就是第二页第一条数据就是10
        int begin = (page - 1) * limit;
        // 3.通过subList获取一页数据
        List<Actor> pageActors = actors.subList(begin, begin + limit);

        // 4.打印数据
        pageActors.forEach(System.out::println);
    }

    /**
     *  基于RowBounds的写法，其中selectList方法传入DAO接口的全限定类名+方法名
     */
    @Test
    public void testSelectPageByRowBounds(){
        // 1.计算begin
        int page = 2;
        int limit = 10;
        int begin = (page - 1) * limit;

        // 2.创建RowBounds对象
        RowBounds rowBounds = new RowBounds(begin, limit);

        // 3.调用sqlSession的selectList API
        List<Actor> list = sqlSession.<Actor>selectList("cn.argentoaskia.dao.PageSelectDAO.selectPageByRowBounds", null, rowBounds);
        list.forEach(System.out::println);
    }

    /**
     * 基于Limit关键字的写法
     */
    @Test
    public void testSelectPageByLimit(){
        int page = 2;
        int limit = 10;
        int begin = (page - 1) * limit;
        List<Actor> actors = mapper.selectPageByLimit(begin, limit);
        actors.forEach(System.out::println);
    }

    /**
     * 基于PageHelper插件的写法，需要在mybatis-config中写上拦截器
     */
    @Test
    public void testSelectPageByPageHelper(){
        int page = 2;
        int limit = 10;
        PageHelper.startPage(page, limit);
        List<Actor> actors = mapper.selectPageByPageHelper();
        actors.forEach(System.out::println);
    }
}
