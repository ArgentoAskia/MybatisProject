package cn.argentoaskia.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.IOException;

//
@Configuration
@PropertySource("classpath:jdbc.properties")
public class MybatisSpringConfigType1 {

    /*
        整合方法1：
        0.导入外部jdbc.properties：@PropertySource()
        1.配置数据源
        2.配置SqlSessionFactoryBean，用于生成SqlSessionFactory
            - 指定数据源：dataSource
            - 指定总配置文件（如果有）：configLocation
            - 指定mapper映射文件（必须有）：mapperLocations
        3.配置MapperScannerConfigurer，用于配对SqlSessionFactory和DAO接口，创建DAO接口的代理实现类并放在容器
            - 指定SqlSessionFactoryBean：sqlSessionFactoryBeanName
            - 指定DAO接口所在的包：basePackage
            如果觉得配置MapperScannerConfigurer配置太麻烦，可以尝试使用@MapperScan注解，配置方法见类前面MybatisSpringConfig顶上的注解
     */
    @Bean
    public DataSource dataSource(@Value("${driver}") String driverName,
                                 @Value("${url}") String url,
                                 @Value("${user}") String username,
                                 @Value("${password}") String password){
        System.out.println(driverName);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        UnpooledDataSource unpooledDataSource = new UnpooledDataSource();
        unpooledDataSource.setUrl(url);
        unpooledDataSource.setDriver(driverName);
        unpooledDataSource.setUsername(username);
        unpooledDataSource.setPassword(password);
        return unpooledDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean( @Value("mybatis-config.xml") String configLocation,
                                                        @Value("cn/argentoaskia/dao/mappers/*.xml") String mapperLocation,
                                                       @Autowired DataSource dataSource) throws IOException {
        System.out.println(dataSource);
        // 1.创建SqlSessionFactoryBean
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 2.读取classpath:mybatis-config.xml，创建ClassPathResource对象，
        // 因为setConfigLocation()需要Resource接口的对象。
        // spring-Resources
        ClassPathResource configLocationResource = new ClassPathResource(configLocation);
        sqlSessionFactoryBean.setConfigLocation(configLocationResource);

        // 3.实现Ant风格的mapper文件扫描（AntPathMatcher）
        // 需要PathMatchingResourcePatternResolver类支撑实现
        // AntPathMatcher、PathMatchingResourcePatternResolver
        // getResources()方法返回所有符合的资源。
        // 底层原理：目录扫描，算法（目录树搜索，DFS）
        ResourcePatternResolver mapperLocationResourceScanner = new PathMatchingResourcePatternResolver();
        Resource[] mapperResources = mapperLocationResourceScanner.getResources(mapperLocation);
        sqlSessionFactoryBean.setMapperLocations(mapperResources);
        // sqlSessionFactoryBean.setTypeAliasesPackage("cn.argentoaskia.beans");

        // 4.配置datasourcces
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(@Value("sqlSessionFactoryBean") String sqlSessionFactoryBeanName,
                                                           @Value("cn.argentoaskia.dao") String basePackage){
        System.out.println(basePackage);
        System.out.println(sqlSessionFactoryBeanName);
        // 5.配置SqlSessionFactoryBeanName
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
        // 6.配置DAO接口所在包，mybatis-spring会将相应的包
        mapperScannerConfigurer.setBasePackage(basePackage);
        return mapperScannerConfigurer;
    }
//

}
