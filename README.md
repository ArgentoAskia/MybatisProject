## mybatis-2-1-mybatis-config-with-java-xml

本篇主要介绍并对比`mybatis`中框架配置文件（mybatis-config）的两种配置方式：`XML`和`Java`代码的配置。

在这里说明一下，在`mybatis`中，框架的配置文件只有`Java`代码的配置形式和`xml`的配置形式，**没有注解的形式**，各位你们看到的所谓的注解形式配置`mybatis`的**都是指**`Mapper`**文件**。

### 1.基于XML的配置方法

基于XML的配置方法，主要是与`mybatis-config.xml`有关，在这个框架配置文件内，你可以填写的标签包括下面几个：

- properties：一般在这个标签内定义一些key-value，也可以导入外部文件的
- settings：框架的相关设置，如日志、缓存配置、驼峰命名转换等
- typeAliases：给包里面的类起别名用到，一般用在mapper文件内
- typeHandlers：自定义类型处理器
- objectFactory：？
- objectWrapperFactory：？
- reflectorFactory：？
- plugins：mybatis的拦截器插件配置相关
- environments：用于配置连接环境，如连接池，事务管理器等
- databaseIdProvider：但涉及到多类型数据库查询的时候需要用来做区分
- mappers：指定mapper文件所在的位置。

基于XML的配置中，**标签的顺序不能改变，编写的模板一般是下面的形式**：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<properties/>
    <settings/>
    <typeAliases/>
    <typeHandlers/>
    <objectFactory/>
    <objectWrapperFactory/>
    <reflectorFactory/>
    <plugins/>
    <environments/>
    <databaseIdProvider/>
    <mappers/>
</configuration>
```

其中具体的配置怎么整，就参考后面的`demo`了。

### 2.基于Java代码的配置方式

基于`Java`代码的配置主要和`mybatis`的`Configuration`类有关，然后在Java代码中，一般使用`sqlSessionFactoryBuilder.build(Configuration configuration)`来配置整个`mybatis`框架。

`Java`代码的配置方式（`Configuration`类）对应于`XML`的相关API：

#### properties标签

```java
// <properties/>标签
public void setVariables(Properties variables);
```

#### settings标签

```java
// <settings/>标签相关，其中<setting/>标签的name属性就是方法名去掉set首字母小写
// value属性可以参考https://mybatis.net.cn/configuration.html#settings
// 为了方面查找，方法将会进行按照属性名称进行排序
public void setAutoMappingBehavior(AutoMappingBehavior autoMappingBehavior);
public void setAutoMappingUnknownColumnBehavior(AutoMappingUnknownColumnBehavior autoMappingUnknownColumnBehavior);
public void setAggressiveLazyLoading(boolean aggressiveLazyLoading);
public void setArgNameBasedConstructorAutoMapping(boolean argNameBasedConstructorAutoMapping);
public void setCacheEnabled(boolean cacheEnabled);
public void setCallSettersOnNulls(boolean callSettersOnNulls);
public void setConfigurationFactory(Class<?> configurationFactory);
public void setDefaultExecutorType(ExecutorType defaultExecutorType);
public void setDefaultStatementTimeout(Integer defaultStatementTimeout);
public void setDefaultFetchSize(Integer defaultFetchSize);
public void setDefaultResultSetType(ResultSetType defaultResultSetType);
public void setDefaultScriptingLanguage(Class<? extends LanguageDriver> driver);
public void setDefaultEnumTypeHandler(Class<? extends TypeHandler> typeHandler);
public void setDefaultSqlProviderType(Class<?> defaultSqlProviderType);
public void setJdbcTypeForNull(JdbcType jdbcTypeForNull);
public void setLazyLoadingEnabled(boolean lazyLoadingEnabled);
public void setLazyLoadTriggerMethods(Set<String> lazyLoadTriggerMethods);
public void setLocalCacheScope(LocalCacheScope localCacheScope);
public void setLogImpl(Class<? extends Log> logImpl);
public void setLogPrefix(String logPrefix);
public void setMapUnderscoreToCamelCase(boolean mapUnderscoreToCamelCase);
public void setMultipleResultSetsEnabled(boolean multipleResultSetsEnabled);
public void setNullableOnForEach(boolean nullableOnForEach);
public void setProxyFactory(ProxyFactory proxyFactory);
public void setReturnInstanceForEmptyRow(boolean returnEmptyInstance);
public void setSafeResultHandlerEnabled(boolean safeResultHandlerEnabled);
public void setSafeRowBoundsEnabled(boolean safeRowBoundsEnabled);
public void setShrinkWhitespacesInSql(boolean shrinkWhitespacesInSql);
public void setUseActualParamName(boolean useActualParamName);
public void setUseColumnLabel(boolean useColumnLabel);
public void setUseGeneratedKeys(boolean useGeneratedKeys);
public void setVfsImpl(Class<? extends VFS> vfsImpl);
```

#### typeAliases标签

想通过代码的形式实现`typeAliases`标签的功能，需要靠`TypeAliasRegistry`类，这个类实际上内部维护了一个`HashMap`，该类有两个核心方法：`registerAlias()`和`getTypeAliases()`

你可以通过下面的代码来注册一个别名：

```java
Class<?> clazz = ...;
TypeAliasRegistry typeAliasRegistry = configuration.getTypeAliasRegistry();
// 以短类名进行注册，或者如果标记了@Alias注解起别名
typeAliasRegistry.registerAlias(clazz);
// 以指定的名称进行注册
typeAliasRegistry.registerAlias("clazz", clazz);
```

```java
public TypeAliasRegistry getTypeAliasRegistry();
// 以指定的名称进行注册
public void registerAlias(String alias, Class<?> value);
// 以短类名进行注册，或者如果标记了@Alias注解起别名
public void registerAlias(Class<?> type);
```

#### typeHandler标签

方法类似于`typeAliases`，注册方法如下：

```java
configuration.getTypeHandlerRegistry().register(TypeHandler typehandler);
```

#### plugin标签

```java
// < plugin/>标签,添加拦截器插件
public void addInterceptor(Interceptor interceptor);
```

其中`Interceptor`是拦截器接口，用户需要实现该接口，重写里面的`intercept()`，来制作拦截器，只要将这个拦截器new出来传递即可，参考下面代码：

```java
Configuration con = new Configuration();
PageInterceptor pageInterceptor = new PageInterceptor();
con.addInterceptor(pageInterceptor);
```

#### objectFactory标签

```java
// <objectFactory/>标签，其中ObjectFactory是一个接口
public void setObjectFactory(ObjectFactory objectFactory);
```

#### objectWrapperFactory标签

```java
// <objectWrapperFactory/>标签，其中ObjectWrapperFactory是一个接口
public void setObjectWrapperFactory(ObjectWrapperFactory objectWrapperFactory);
```

#### reflectorFactory标签

```java
// <reflectorFactory/>标签，其中ReflectorFactory是一个接口
public void setReflectorFactory(ReflectorFactory reflectorFactory);
```

#### environments标签

这个标签主要用来配置环境，常用。因此参数可能比较多。

基本靠下面的方法来设置`Environment`：

```java
public void setEnvironment(Environment environment)
```

其中`Environment`类初始化有三个基本设置：

```java
public Environment(String id, TransactionFactory transactionFactory, DataSource dataSource)
```

- `id`：对应`environment`标签的`id`
- `transactionFactory`：对应`environment`标签的`transactionManager`，在`org.apache.ibatis.transaction.*`下默认有两个实现，可以直接创建这两个实现的对象即可。
- dataSource：对应`environment`标签的`dataSource`，无需多讲，`dddd`。

创建方式参考下面代码：

```java
String id = "dev";
JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
UnpooledDataSource unpooledDataSource = new UnpooledDataSource();
unpooledDataSource.setDriver("com.mysql.cj.jdbc.Driver");
unpooledDataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
unpooledDataSource.setPassword("sujiewei");
unpooledDataSource.setUsername("root");
Environment environment = new Environment(id, jdbcTransactionFactory, unpooledDataSource);
configuration.setEnvironment(environment);
```

#### databaseIdProvider标签

自定义`databaseIdProvider`

`databaseIdProvider`标签比较特别，在Configuration类中主要靠下面的方法来设置`provider`。

```java
public void setDatabaseId(String databaseId);
```

具体的设置方式可以参考下面的代码：

```java
DataSource dataSource = configuration.getEnvironment().getDataSource();
VendorDatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
String databaseId = databaseIdProvider.getDatabaseId(dataSource);
configuration.setDatabaseId(databaseId);
```

#### mappers标签

xml模式下一般有三种mapper的注册方式：指定dao接口（class属性、package标签）、指定url（网络mapper的XML）、指定resource（本机mapper的XML）

其中注册dao接口简单，只要靠下面的方法：

```java
// class属性
public <T> void addMapper(Class<T> type);
// package标签
public void addMappers(String packageName);
```

 但如果你想通过指定`resource`的方式来实现注册，可能就没那么简单了，翻看`mybatis`的源代码，找打了方式，你可以通过下面的代码来实现这种注册方式：

```java
// 读入mapper文件
try (InputStream inputStream = Resources.getResourceAsStream(mapperResource)) {
    // 创建XMLMapperBuilder用于解析mapper
    XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, mapperResource, configuration.getSqlFragments());
    // 解析mapper
    mapperParser.parse();
}
```

