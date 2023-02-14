package cn.argentoaskia.mybatis;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MybatisConfig {
    private Configuration configuration;
    public MybatisConfig(){
        /*
        TODO: 1.创建配置
         */
        configuration = new Configuration();
        /*
        TODO: 2.设置日志实现。
            方法1，直接传递日志实现类：configuration.setLogImpl(Log4jImpl.class)，一般用于自定义的日志
            方法2，使用LogFactory.useXXX()方法
            所有的可用日志实现可以在包org.apache.ibatis.logging.*下查看，你可以在这个包下看能使用那些日志
            甚至可以实现Log接口和LogFactory来自定义日志
         */

        // configuration.setLogImpl(Log4jImpl.class);
        LogFactory.useLog4JLogging();

        /*
        TODO: 3.配置连接，事务，涉及到类Environment，对应Environment标签。
         需要指定id值，TransactionFactory(transactionManager)，DataSource(dataSource)
         */
        //
        String id = "dev";

        // 事务管理的实现mybatis默认有两个，在包org.apache.ibatis.transaction.*下
        // 后期可以替换成Spring的事务管理器
        JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();

        // 在包org.apache.ibatis.datasource下也内置了两个常用的datasource
        // datasource有两种配置方法：直接new UnpooledDataSource(代码来配置连接参数)和采用UnpooledDataSourceFactory(针对jdbc.properties)
        /*
            方法1代码：
         */
        UnpooledDataSource unpooledDataSource = new UnpooledDataSource();
        unpooledDataSource.setDriver("com.mysql.cj.jdbc.Driver");
        unpooledDataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        unpooledDataSource.setPassword("sujiewei");
        unpooledDataSource.setUsername("root");

        /*
            方法2代码：

        UnpooledDataSourceFactory unpooledDataSourceFactory = new UnpooledDataSourceFactory();
        Properties properties = new Properties();
        InputStream jdbcConfig = getClass().getResourceAsStream("/jdbc.properties");
        properties.load(jdbcConfig);
        unpooledDataSourceFactory.setProperties(properties);
        DataSource unpooledDataSource = unpooledDataSourceFactory.getDataSource();
         */
        Environment environment = new Environment(id, jdbcTransactionFactory, unpooledDataSource);
        configuration.setEnvironment(environment);

    }

    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * 添加Mapper文件位置
     * @param daoClass
     */
    public void registerMappers(Class<?>... daoClass){
        for (Class<?> aClass : daoClass) {
            configuration.addMapper(aClass);
        }
    }

    public void registerMappers(String... mapperResources) throws IOException {
        for (String mapperResource :
                mapperResources) {
            try (InputStream inputStream = Resources.getResourceAsStream(mapperResource)) {
                XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, mapperResource, configuration.getSqlFragments());
                mapperParser.parse();
            }
        }
    }

    /**
     * 添加MapperDao所在的包名
     * @param packageName
     */
    public void registerMapperPackage(String packageName){
      configuration.addMappers(packageName);
    }
}
