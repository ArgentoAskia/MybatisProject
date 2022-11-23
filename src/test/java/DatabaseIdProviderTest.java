import bean.Emp;
import dao.EmpDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DatabaseMetaData;
import java.util.List;

public class DatabaseIdProviderTest {
    private SqlSessionFactory mysqlSessionFactory;
    private SqlSessionFactory oracleSessionFactory;

    // 环境搜索顺序
    // 1.创建sqlSessionFactoryBuilder选取相应的环境
    // 2.创建mysqlSessionFactory的时候之后，通过dataSource对象的DatabaseMetaData中的getDatabaseProductName()获取数据库软件的名称
    // 3.匹配databaseIdProvider，找到对象的databaseId
    // 4.找到DAO接口的mapper中所有匹配的databaseId的接口，其他不匹配或者不带databaseId的接口全部丢弃

    @Before
    public void before() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream mybatisConfig = EmpDAO.class.getResourceAsStream("/mybatis-config.xml");
        mysqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig, "mysql");
        mybatisConfig.close();

        // 要创建两个流，不然会出现Stream close的IOException
        InputStream mybatisConfig2 = EmpDAO.class.getResourceAsStream("/mybatis-config.xml");
        oracleSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfig2, "oracle");
        mybatisConfig2.close();
    }

    @Test
    public void testSelectAll(){
        System.out.println("下面是接口在两套不同的环境下的执行结果, 在MySQL环境下只有WithMySQL的方法能执行, 在Oracle环境下只有WithOracle的方法能执行");
        System.out.println("核心在于databaseId");
        System.out.println("多套环境下多个数据库的处理还是挺麻烦的");
        SqlSession sqlSession = mysqlSessionFactory.openSession();
        EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
        System.out.println("调用方法selectAllWithMySQL()");
        List<Emp> emps = mapper.selectAllWithMySQL();
        // 下面的方法将会报找不到mapper错误
        // List<Emp> emps = mapper.selectAllWithOracle();
        emps.forEach(System.out::println);
        sqlSession.close();

        System.out.println();

        SqlSession sqlSession1 = oracleSessionFactory.openSession();
        EmpDAO mapper1 = sqlSession1.getMapper(EmpDAO.class);
        System.out.println("调用方法selectAllWithOracle()");
        List<Emp> emps1 = mapper1.selectAllWithOracle();
        // 下面的方法将会报找不到mapper错误
        // List<Emp> emps1 = mapper1.selectAllWithMySQL();
        emps1.forEach(System.out::println);
        sqlSession1.close();
    }
}
