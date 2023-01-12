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

### 方式1

### 方式2

### 方式3

