package cn.argentoaskia.dao;

import cn.argentoaskia.beans.FilmTextOrigin;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class FilmTextDAOXMLTest {

    private SqlSession sqlSession;
    private FilmTextDAOXML mapper;
    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = FilmTextDAOXML.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(FilmTextDAOXML.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void fTestFileTextDAOXMLSelectAll(){
        System.out.println("----------> 1.FileTextDAOXMLSelectAll <----------");
        List<FilmTextOrigin> filmTextOrigins = mapper.selectAll();
        for (FilmTextOrigin fto :
                filmTextOrigins) {
            System.out.println(fto);
        }
        System.out.println("=================================================\n");
    }

    @Test
    public void eTestFileTextDAOXMLSelectById(){
        System.out.println("----------> 2.FileTextDAOXMLSelectById <----------");
        FilmTextOrigin filmTextOrigin = mapper.selectById(100);
        System.out.println(filmTextOrigin);
        System.out.println("=================================================\n");
    }

    @Test
    public void dTestFileTextDAOXMLInsert(){
        System.out.println("----------> 3.FileTextDAOXMLInsert <----------");
        FilmTextOrigin filmTextOrigin = new FilmTextOrigin();
        filmTextOrigin.setFilm_id(1001)
                .setTitle("Test Film")
                .setDescription("Test Film Description");
        Integer changeRow = mapper.insert(filmTextOrigin);
        if (changeRow > 0) {
            System.out.println("成功插入1条数据！！！");
        } else {
            System.out.println("插入失败！！！");
        }
        System.out.println("=================================================\n");
    }

    @Test
    public void cTestFileTextDAOXMLUpdate(){
        System.out.println("----------> 4.FileTextDAOXMLUpdate <----------");
        FilmTextOrigin filmTextOrigin = new FilmTextOrigin();
        filmTextOrigin.setFilm_id(1001)
                .setTitle("Test Film update")
                .setDescription("Test Film update Description");
        Integer changeRow = mapper.update(filmTextOrigin);
        if (changeRow > 0) {
            System.out.println("成功修改1条数据！！！");
        } else {
            System.out.println("修改失败！！！");
        }
        System.out.println("=================================================\n");
    }

    @Test
    public void bTestFileTextDAOXMLDelete(){
        System.out.println("----------> 5.FileTextDAOXMLUpdate <----------");
        FilmTextOrigin filmTextOrigin = new FilmTextOrigin();
        filmTextOrigin.setFilm_id(1001)
                .setTitle("Test Film update")
                .setDescription("Test Film update Description");
        Integer changeRow = mapper.delete(filmTextOrigin);
        if (changeRow > 0) {
            System.out.println("成功删除1条数据！！！");
        } else {
            System.out.println("删除失败！！！");
        }
        System.out.println("=================================================\n");
    }
}
