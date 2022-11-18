package cn.argentoaskia;

import cn.argentoaskia.beans.FilmTextOrigin2;
import cn.argentoaskia.dao.FilmTextDAOParameter;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FilmTextDAOParameterTest {

    private SqlSession sqlSession;
    private FilmTextDAOParameter mapper;
    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = FilmTextDAOParameter.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(FilmTextDAOParameter.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testInsert3(){
        FilmTextOrigin2 filmTextOrigin2 = new FilmTextOrigin2();
        filmTextOrigin2.setFilm_id(1001)
                .setTitle("insert test")
                .setDescription("desc test");
        Integer changeRow = mapper.insert3(filmTextOrigin2);
        System.out.println(changeRow);
    }

    @Test
    public void testInsertMap(){
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", 1001);
        params.put("title", "insert test");
        params.put("desc", "desc test");
        Integer changeRow = mapper.insert2(params);
        System.out.println(changeRow);
    }

    @Test
    public void testDelete3(){
        Integer integer = mapper.delete3(1000, "ZORRO ARK", "A Intrepid Panorama of a Mad Scientist And a Boy who must Redeem a Boy in A Monastery");
        System.out.println(integer);
    }

    @Test
    public void testUpdate(){
        FilmTextOrigin2 filmTextOrigin2 = new FilmTextOrigin2();
        filmTextOrigin2.setFilm_id(1000)
                .setTitle("test")
                .setDescription("test");
        FilmTextOrigin2 filmTextOrigin21 = new FilmTextOrigin2();
        filmTextOrigin21.setFilm_id(1000);
        Integer update = mapper.update(filmTextOrigin21, filmTextOrigin2);
        System.out.println(update);
    }
    @Test
    public void testUpdate2(){
        FilmTextOrigin2 filmTextOrigin2 = new FilmTextOrigin2();
        filmTextOrigin2.setFilm_id(1000)
                .setTitle("test")
                .setDescription("test");
        FilmTextOrigin2 filmTextOrigin21 = new FilmTextOrigin2();
        filmTextOrigin21.setFilm_id(1000);
        Integer update = mapper.update2(filmTextOrigin21, filmTextOrigin2);
        System.out.println(update);
    }

    @Test
    public void testUpdate3(){
        FilmTextOrigin2 filmTextOrigin2 = new FilmTextOrigin2();
        filmTextOrigin2.setFilm_id(1000)
                .setTitle("test")
                .setDescription("test");
        FilmTextOrigin2 filmTextOrigin21 = new FilmTextOrigin2();
        filmTextOrigin21.setFilm_id(1000);
        Integer update = mapper.update3(filmTextOrigin21, filmTextOrigin2);
        System.out.println(update);
    }

    @Test
    public void testUpdate4(){
        FilmTextOrigin2 filmTextOrigin2 = new FilmTextOrigin2();
        filmTextOrigin2.setFilm_id(1000)
                .setTitle("test")
                .setDescription("test");
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", 1000);
        Integer update = mapper.update4(params, filmTextOrigin2);
        System.out.println(update);
    }
}
