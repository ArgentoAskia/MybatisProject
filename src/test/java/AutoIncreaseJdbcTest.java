import bean.Salgrade;
import dao.SalgradeDAO;
import dao2.SalgradeDAO2;
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

public class AutoIncreaseJdbcTest {

    private SqlSession sqlSession;
    private SalgradeDAO mapper;
    private SalgradeDAO2 mapper2;

    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = SalgradeDAO.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(SalgradeDAO.class);
        mapper2 = sqlSession.getMapper(SalgradeDAO2.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testAutoIncreaseJdbcWithXML(){
        Salgrade salgrade = new Salgrade();
        salgrade.setLosal(1201.00);
        salgrade.setHisal(3000.00);
        int insertFlag = mapper.insert(salgrade);
        if (insertFlag > 0){
            Integer gradeKey = salgrade.getGrade();
            System.out.println("新增数据的自增主键值：" + gradeKey);
        }else{
            System.out.println("插入失败");
        }
    }

    @Test
    public void testAutoIncreaseJdbcWithAnnotation(){
        Salgrade salgrade = new Salgrade();
        salgrade.setLosal(1201.00);
        salgrade.setHisal(3000.00);
        int insertFlag = mapper2.insert(salgrade);
        if (insertFlag > 0){
            Integer gradeKey = salgrade.getGrade();
            System.out.println("新增数据的自增主键值：" + gradeKey);
        }else{
            System.out.println("插入失败");
        }
    }

}
