## Mybatis-Spring框架整合

### 简介

早期在使用`Spring`框架的项目中使用`mybatis`是一件非常恶心的事情，在`Mybatis`时期，因为新版本的发布比`Spring`的晚，`Spring`团队又不愿意为了`Mybatis`重新发布`GA`版本。`mybatis`社区为了解决和`Spring`整合的问题，设计了一个专门用来整合的中间框架：`mybatis-spring`，我们本次的框架整合，也是以这个框架为主。

需要注意，如果你不使用这个框架，您仍然能够在`Spring`中整合`Mybatis`，因为理论上你可以自行在`Spring`对象容器中创建并`AutoWired`多种`SqlSessionFactory`对象，调用`SqlSession`的方法来进行查询，使用`Mybatis-Spring`旨在为了能够直接提供`DAO`接口的`AutoWired`功能，减轻代码量和工作量。

`Mybatis-Spring`框架常见有三种整合方式：

- 基于`MapperScannerConfigurer`方式配置
- 基于`SqlSessionTemplate`方式配置
- 基于`DAOSupport`方式配置

其中基于`SqlSessionTemplate`方式将会默认整和`Spring`事务管理器

还有在`Mybatis-Spring`中，`SqlSessionFactoryBean`可以看成是`Configuration`类，也就是相当于`Mybatis-config.xml`。因为`SqlSessionFactoryBean`的方法很多都是`Configuration`类的，这两个配置类的职责都是一样的：提供创建`SqlSessionFactory`所需的配置。`SqlSessionTemplate`类可以看成是`SqlSession`，如果你看看`SqlSessionTemplate`你就知道了，它本身就是实现了`SqlSession`的。

一般建议使用前面两种方法，除非需要对查询结果进行二次加工，否则不建议采用`DAO Support`。

### 配置前的说明

无论哪种方式，都需要用到`DataSource` 和`SqlSessionFactoryBean`，因此在`XML`的配置中，单独创建了一个容器`Spring-dao.xml`来共享`DataSource`和`SqlSessionFactoryBean`。因此你在主要的`XML`配置方式中会看到其他方式会引用`Spring-dao.xml`这个容器。

### 基于MapperScannerConfigurer方式配置

> `datasource`+`SqlSessionFactoryBean`+`MapperScannerConfigurer`实现`Autowired DAO`接口

-----

`MapperScannerConfigurer`类，通过这种方式能够直接创建`DAO`接口的代理实现类，并放进`Spring`容器中，这种方式的创建方法可以参考下面的代码和配置：

> 基于`XML`配置：
>
> - `spring-dao.xml`
> - `spring-dao-1.xml`
> - `jdbc.properties`
>
> 基于`JavaConfig`配置：
>
> - `MybatisSpringConfigType1.java`
> - `MybatisSpringConfigType2.java`中被注释掉的第二个`@MapperScan`注解
> - `jdbc.properties`

大家可以跑下工程中的`SpringDAOJavaConfigTypeTest`和`SpringDAOXMLType1Test`来查看整合测试结果。

-----

基本的整合过程如下：

1. 配置`DataSource`，任意`DataSource`均可。
2. 配置`SqlSessionFactoryBean`，提供下列参数中其中几个：
   1. `configLocation`：`mybatis-config.xml`的位置
   2. `configuration`：`configuration`对象，在使用代码形式配置`mybatis`的时候介绍过这个类，`1.3.0`版本之后`mybatis`为了方便开发着配置`Settings`标签内容，将这个类开放。理论上你可以就配置这个对象来使`用mybatis`即可。
   3. `environment`：对应`environment`标签的id值
   4. `dataSource`：你懂的！
   5. `configurationProperties`：对应`mybatis-config`中的`properties`标签
   6. `mapperLocations`：对应Mappers标签，支持Ant风格匹配，理论上配置了这个就无需要配置`MapperScannerConfigurer`（**当然只是理论上**）
   7. **特别注意configuration和configLocation只能二选一！！！！**
3. 配置`MapperScannerConfigurer`，提供下列参数中其中几个：
   1. `sqlSessionFactoryBeanName`：配置的`sqlSessionFactoryBean`的`id`值
   2. `basePackage`：`DAO`接口所在的包，`Mybatis-spring`框架会创建这些接口的代理对象并放进容器内

-------

配置`MapperScannerConfigurer`的最根本的原因，是创建`DAO`接口的代理对象并把它放进`spring`容器。如果不配置`MapperScannerConfigurer`，则只能通过`sqlSessionFactoryBean`打开`sqlSession`来进行查询，参考下面代码：

```java
 ( (SqlSessionFactory)sqlSessionFactoryBean.getObject() ).openSession()
```

也可以使用`@MapperScan`注解来代替麻烦的`MapperScannerConfigurer`，这两个东西互相通用，参考`MybatisSpringConfigType2`属性名称上对应是：

- `basePackages`（`MapperScan`）=`basePackage`（`MapperScannerConfigurer`）
- `sqlSessionTemplateRef` = `sqlSessionTemplateBeanName`
- `sqlSessionFactoryRef` = `sqlSessionFactoryBeanName`
- `annotationClass` = `annotationClass`

### 基于SqlSessionTemplate方式配置

> 1. `datasource` + `SqlSessionFactoryBean` + `SqlSessionTemplate`实现包揽`Spring`事务框架 + 原生`SqlSession`方式，参考`spring-dao-2.xml`
> 2. `datasource` + `sqlSessionFactoryBean` + `SqlSessionTemplate` + `MapperScannerConfigurer`方式实现`Autowired`自动注入`DAO`接口，参考：`MybatisSpringConfigType2`中第一个`@MapperScan`

当涉及到事务的时候也可以使用`SqlSessionTemplate`的方式来进行配置，`SqlSessionTemplate`相当于`SqlSession`，具体的配置方式更加简单：

1. 配置`DataSource`
2. 配置`sqlSessionFactoryBean`
3. 配置`SqlSessionTemplate`，提供`sqlSessionFactory`（`sqlSessionFactoryBean`）对象
4. 如果希望直接`AutoWired`接口，则还需要配置`MapperScannerConfigurer`，提供`sqlSessionTemplateBeanName`和`basePackages`

-----

可能有同学会对配置`SqlSessionTemplate`的时候产生一些疑惑，明明需要的是`sqlSessionFactory`，但是提供的却是`sqlSessionFactoryBean`，这是因为`Spring`在注入的时候可以靠`FactoryBean`接口来实现这种类似于`Wrapper`的效果，具体可以参考`Spring`官网教程[点击这里](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-extension-factorybean)

### 基于DAOSupport方式配置

基于`DAOSupport`方式的代码，如果希望在查询完结果之后，能够对结果进行处理，则可以使用这种方式配置。

步骤可以参考：

1. 创建一个继承`SqlSessionDaoSupport`类的`DAOSupport`类，并实现`DAO`接口
2. 编写`Sql`查询代码，`SqlSessionDaoSupport`类内有获取`SqlSession`和`SqlSessionFactory`的`getter`方法
3. 在`Spring`容器中创建`DAOSupport`类的对象
4. 测试类中注入并使用

