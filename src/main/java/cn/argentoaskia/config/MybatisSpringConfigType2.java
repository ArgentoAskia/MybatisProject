package cn.argentoaskia.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.omg.CORBA.StringHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

// 也可以使用MapperScan注解来代替掉MapperScannerConfigurer的配置
// 核心需要配置两个属性：value|basePackages|basePackageClasses && sqlSessionFactoryRef|sqlSessionTemplateRef
// sqlSessionFactoryRef:sqlSessionFactoryBean的id值
// sqlSessionTemplateRef:SqlSessionTemplate的id值
// 甚至还可以直接指明扫描哪种类型的注解，指定annotationClass属性即可，如使用第二个@MapperScan的话，则只能扫描有标记Mapper注解的DAO接口
@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages =  "cn.argentoaskia.dao",
        sqlSessionFactoryRef = "sqlSessionFactoryBean")
//@MapperScan(basePackages =  "cn.argentoaskia.dao",
//        sqlSessionFactoryRef = "sqlSessionFactoryBean",
//        annotationClass = Mapper.class)
public class MybatisSpringConfigType2 {
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
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Value("mybatis-config.xml") String configLocation,
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

    // 在这里可以添加一些线程框架支持
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(
            @Autowired SqlSessionFactory sqlSessionFactory
    ){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(
            @Value("sqlSessionTemplate") String sqlSessionTemplateName,
            @Value("cn.argentoaskia.dao") String daoPackageLocation
    ){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionTemplateBeanName(sqlSessionTemplateName);
        mapperScannerConfigurer.setBasePackage(daoPackageLocation);
        return mapperScannerConfigurer;
    }

}
