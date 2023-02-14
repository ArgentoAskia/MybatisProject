package cn.argentoaskia.dao;

import cn.argentoaskia.bean.FilmText;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DynamicSQLForeachLabelTest {
    private SqlSession sqlSession;
    private FilmTextDAO3 mapper;

    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = FilmTextDAO3.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(FilmTextDAO3.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testForeachArray(){
        FilmText filmText1 = new FilmText();
        FilmText filmText2 = new FilmText();
        FilmText filmText3 = new FilmText();
        filmText1.setDescription("Test1").setFilmId(1001).setTitle("Test1");
        filmText2.setDescription("Test2").setFilmId(1002).setTitle("Test2");
        filmText3.setDescription("Test3").setFilmId(1003).setTitle("Test3");

        FilmText filmText4 = new FilmText();
        FilmText filmText5 = new FilmText();
        FilmText filmText6 = new FilmText();
        filmText4.setDescription("Test4").setFilmId(1004).setTitle("Test4");
        filmText5.setDescription("Test5").setFilmId(1005).setTitle("Test5");
        filmText6.setDescription("Test6").setFilmId(1006).setTitle("Test6");

        FilmText filmText7 = new FilmText();
        FilmText filmText8 = new FilmText();
        FilmText filmText9 = new FilmText();
        filmText7.setDescription("Test7").setFilmId(1007).setTitle("Test7");
        filmText8.setDescription("Test8").setFilmId(1008).setTitle("Test8");
        filmText9.setDescription("Test9").setFilmId(1009).setTitle("Test9");

        int i = mapper.insertArray1(filmText1, filmText2, filmText3);
        int j = mapper.insertArray2(new FilmText[]{filmText4, filmText5, filmText6});
        int k = mapper.insertArray3(filmText7, filmText8, filmText9);

    }

    @Test
    public void testForeachList(){
        FilmText filmText1 = new FilmText();
        FilmText filmText2 = new FilmText();
        FilmText filmText3 = new FilmText();
        filmText1.setDescription("Test1").setFilmId(1001).setTitle("Test1");
        filmText2.setDescription("Test2").setFilmId(1002).setTitle("Test2");
        filmText3.setDescription("Test3").setFilmId(1003).setTitle("Test3");
        List<FilmText> filmTextList = new LinkedList<>();
        filmTextList.add(filmText1);
        filmTextList.add(filmText2);
        filmTextList.add(filmText3);
        mapper.insertList1(filmTextList);

        FilmText filmText4 = new FilmText();
        FilmText filmText5 = new FilmText();
        FilmText filmText6 = new FilmText();
        filmText4.setDescription("Test4").setFilmId(1004).setTitle("Test4");
        filmText5.setDescription("Test5").setFilmId(1005).setTitle("Test5");
        filmText6.setDescription("Test6").setFilmId(1006).setTitle("Test6");
        List<FilmText> filmTextList2 = new LinkedList<>();
        filmTextList2.add(filmText4);
        filmTextList2.add(filmText5);
        filmTextList2.add(filmText6);
        mapper.insertList2(filmTextList2);


        FilmText filmText7 = new FilmText();
        FilmText filmText8 = new FilmText();
        FilmText filmText9 = new FilmText();
        filmText7.setDescription("Test7").setFilmId(1007).setTitle("Test7");
        filmText8.setDescription("Test8").setFilmId(1008).setTitle("Test8");
        filmText9.setDescription("Test9").setFilmId(1009).setTitle("Test9");
        List<FilmText> filmTextList3 = new LinkedList<>();
        filmTextList3.add(filmText7);
        filmTextList3.add(filmText8);
        filmTextList3.add(filmText9);
        mapper.insertList3(filmTextList3);

        FilmText filmText10 = new FilmText();
        FilmText filmText11 = new FilmText();
        FilmText filmText12 = new FilmText();
        filmText10.setDescription("Test10").setFilmId(1010).setTitle("Test10");
        filmText11.setDescription("Test11").setFilmId(1011).setTitle("Test11");
        filmText12.setDescription("Test12").setFilmId(1012).setTitle("Test12");
        List<FilmText> filmTextList4 = new LinkedList<>();
        filmTextList4.add(filmText10);
        filmTextList4.add(filmText11);
        filmTextList4.add(filmText12);
        mapper.insertList4(filmTextList4);
    }

    @Test
    public void testForeachMap(){
        FilmText filmText1 = new FilmText();
        FilmText filmText2 = new FilmText();
        FilmText filmText3 = new FilmText();
        filmText1.setDescription("Test1").setFilmId(1001).setTitle("Test1");
        filmText2.setDescription("Test2").setFilmId(1002).setTitle("Test2");
        filmText3.setDescription("Test3").setFilmId(1003).setTitle("Test3");
        Map<String, FilmText> stringFilmTextMap = new HashMap<>();
        stringFilmTextMap.put("filmText1", filmText1);
        stringFilmTextMap.put("filmText2", filmText2);
        stringFilmTextMap.put("filmText3", filmText3);
        mapper.insertMap1(stringFilmTextMap);
    }

    @Test
    public void testForeachMap2(){
        FilmText filmText1 = new FilmText();
        FilmText filmText2 = new FilmText();
        FilmText filmText3 = new FilmText();
        filmText1.setDescription("Test1").setFilmId(1001).setTitle("Test1");
        filmText2.setDescription("Test2").setFilmId(1002).setTitle("Test2");
        filmText3.setDescription("Test3").setFilmId(1003).setTitle("Test3");
        Map<String, FilmText> stringFilmTextMap1 = new HashMap<>();
        stringFilmTextMap1.put("filmText1", filmText1);
        stringFilmTextMap1.put("filmText2", filmText2);
        stringFilmTextMap1.put("filmText3", filmText3);

        FilmText filmText7 = new FilmText();
        FilmText filmText8 = new FilmText();
        FilmText filmText9 = new FilmText();
        filmText7.setDescription("Test7").setFilmId(1007).setTitle("Test7");
        filmText8.setDescription("Test8").setFilmId(1008).setTitle("Test8");
        filmText9.setDescription("Test9").setFilmId(1009).setTitle("Test9");
        Map<String, FilmText> stringFilmTextMap2 = new HashMap<>();
        stringFilmTextMap2.put("filmText7", filmText7);
        stringFilmTextMap2.put("filmText8", filmText8);
        stringFilmTextMap2.put("filmText9", filmText9);
        mapper.insertMap2(stringFilmTextMap1, stringFilmTextMap2);
    }

    @Test
    public void testUpdate(){
        Map<String, Object> filmText = new HashMap<>();
        filmText.put("film_id", 1000);
        filmText.put("title", "Test1");
        filmText.put("description", "Test1");
        mapper.update(filmText);
    }
}
