## mybatis-2-1-mybatis-config-with-java-xml

本篇主要介绍`mybatis`中框架配置文件（`mybatis-config`）的两种配置方式：`XML`和`Java`代码的配置。

在这里说明一下，在`mybatis`中，框架的配置文件（`mybatis-config`）只有`Java`代码的配置形式和`xml`的配置形式，**没有注解的形式**，各位你们看到的所谓的注解形式配置`mybatis`的**都是指配置**`Mapper`**文件，即具体写SQL语句的地方**。

这里给已经混乱的同学说明一下，`mybatis`框架配置起来使用一般需要两个配置文件：

1. `mybatis-config`：代指框架的配置文件，俗称总配置文件，规定数据库连接设置，日志输出，`properties`键值对和指定`mapper`位置等，有两种配置方式：`XML`和`Java`代码（`Configuration`类）
2. `Mapper`：代指`DAO`接口中的各种映射文件，写`SQL`语句的地方，一个`Mapper`绑定一个`DAO`接口，有三种配置方式：`XML`、注解和`Provider`类方式

`mybatis-config`配置文件只要写一次就`ok`，`Mapper`则不一样，理论上有多少个`DAO`接口就需要多少个`Mapper`，当然注解形式写`Mapper`时，`SQL`一般写在`DAO`接口里面就`ok`，因此这个时候`DAO`接口自己就是一个`Mapper`。

## 总配置文件框架

总配置文件的基本框架：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

</configuration>
```

大家可以把这个框架复制一份弄成一个`idea`的`live template`。

总配置文件通常会放在`maven`项目的`Resources`文件夹下面，这个配置文件的最基本内容有俩个部分：数据库连接和`Mapper`文件的位置。

```xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 数据库连接 -->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"></transactionManager>
            <dataSource type="UNPOOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://192.168.43.106:3306/mybatis"/>
                <property name="username" value="root"/>
                <property name="password" value="sujiewei"/>
            </dataSource>
        </environment>
    </environments>

    <!-- mapper文件的位置 -->
    <mappers>
        <mapper resource="tk/mybatis/simple/mapper/CountryMapper.xml"/>
    </mappers>
</configuration>
```

## 两种配置方式属性值参考

### 1.基于XML的配置方法

基于`XML`的配置方法，主要是与`mybatis-config.xml`有关，在这个框架配置文件内，你可以填写的标签包括下面几个：

- `properties`：一般在这个标签内定义一些`key-value`，也可以导入外部文件的
- `settings`：框架的相关设置，如日志、缓存配置、驼峰命名转换等
- `typeAliases`：给包里面的类起别名用到，一般用在`mapper`文件内
- `typeHandlers`：自定义类型处理器
- `objectFactory`：？
- `objectWrapperFactory`：？
- `reflectorFactory`：？
- `plugins`：`mybatis`的拦截器插件配置相关
- `environments`：用于配置连接环境，如连接池，事务管理器等
- `databaseIdProvider`：但涉及到多类型数据库查询的时候需要用来做区分
- `mappers`：指定`mapper`文件所在的位置。

基于`XML`的配置中，**标签的顺序不能改变，编写的模板一般是下面的形式**：

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

其中具体的配置可以参考：

`Mapper`

### 2.基于Java代码的配置方式

基于`Java`代码的配置主要和`mybatis`的`Configuration`类有关，然后在`Java`代码中，一般使用`sqlSessionFactoryBuilder.build(Configuration configuration)`来配置整个`mybatis`框架。

`Java`代码的配置方式（`Configuration`类）对应于`XML`的相关`API`：

#### properties标签

`properties`标签对应`Configuration`类中的下面的方法：

```java
// <properties/>标签
public void setVariables(Properties variables);
```

`properties`标签是属性标签，你可以在`mybatis-config.xml`中预先定义一些`key-value`：

```properties
# config.properties文件内容
class=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/sakila
```

`properties`同时具备`resource`属性，可以指定外部的`properties`文件。

```xml
<properties resource="org/mybatis/jdbc/config.properties">
    <property name="username" value="root"></property>
    <property name="password" value="root"></property>
</properties>
```

然后在其他地方替换掉动态配置的属性值，替换方法是使用：${`name`属性值}

```xml
<dataSource type="POOLED">
  <property name="driver" value="${driver}"/>
  <property name="url" value="${url}"/>
  <property name="username" value="${username}"/>
  <property name="password" value="${password}"/>
</dataSource>
```

如果是代码形式的设置，你可以这样写：

```java
// 读入Properties文件：核心时class.getResourcesAsStream()方法
InputStream config = loadPropertiesFileToInputStream("org/mybatis/jdbc/config.properties");
Properties properties = new Properties();
properties.load(config);
properties.setProperty("username", "root");
properties.setProperty("password", "root");
Configuration configuration = new Configuration();
configuration.setVariables(properties);
```

#### settings标签

`settings`标签是`mybatis-config.xml`中最为重要的标签，他会改变`mybatis`框架的配置情况。在`XML`中的配置方式和`properties`差不多，但是在`Java`代码中的配置方式却很特别，在`Configuration`类中有`Setter` 方法和他的配置有关，具体参考下面的说明：

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

下面这里出一个完整的`settings`标签的配置，同时给出对应的`Java`代码版本。

```xml
<settings>
  <setting name="autoMappingBehavior" value="PARTIAL"/>
  <setting name="autoMappingUnknownColumnBehavior" value="WARNING"/>
  <setting name="cacheEnabled" value="true"/>
  <setting name="defaultExecutorType" value="SIMPLE"/>
  <setting name="defaultFetchSize" value="100"/>
  <setting name="defaultStatementTimeout" value="25"/>
  <setting name="jdbcTypeForNull" value="OTHER"/>
  <setting name="lazyLoadingEnabled" value="true"/>
  <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode,toString"/>
  <setting name="localCacheScope" value="SESSION"/>
  <setting name="mapUnderscoreToCamelCase" value="false"/>
  <setting name="multipleResultSetsEnabled" value="true"/>
  <setting name="safeRowBoundsEnabled" value="false"/>
  <setting name="useColumnLabel" value="true"/>
  <setting name="useGeneratedKeys" value="false"/>  
</settings>
```

```java
Configuration configuration = new Configuration();
// AutoMappingBehavior是一个枚举类
configuration.setAutoMappingBehavior(AutoMappingBehavior.PARTIAL);
// AutoMappingUnknownColumnBehavior同样是一个枚举类，下面如果没有特别说明默认都是枚举类
configuration.setAutoMappingUnknownColumnBehavior(AutoMappingUnknownColumnBehavior.WARNING);
configuration.setCacheEnabled(true);
configuration.setDefaultExecutorType(ExecutorType.SIMPLE);
configuration.setDefaultFetchSize(100);
configuration.setDefaultStatementTimeout(25);
configuration.setJdbcTypeForNull(JdbcType.OTHER);
configuration.setLazyLoadingEnabled(true);
Set<String> strings = new java.util.HashSet<>(Collections.emptySet());
strings.add("equals");
strings.add("clone");
strings.add("hashCode");
strings.add("toString");
configuration.setLazyLoadTriggerMethods(strings);
configuration.setLocalCacheScope(LocalCacheScope.SESSION);
configuration.setMapUnderscoreToCamelCase(false);
configuration.setMultipleResultSetsEnabled(true);
configuration.setSafeRowBoundsEnabled(false);
configuration.setUseColumnLabel(true);
configuration.setUseGeneratedKeys(false);
```

具体每个`setting`的值和使用方式，参考后面的文章。

#### typeAliases标签

`typeAliases`类型别名可以为`Java`类型设置一个缩写名字。它仅为了在写`Mapper.xml`的时候能够降低冗余的全限定类名书写。

`typeAliases`标签的写法如下：

```xml
<typeAliases>
  <typeAlias alias="Author" type="domain.blog.Author"/>
  <typeAlias alias="Blog" type="domain.blog.Blog"/>
  <typeAlias alias="Comment" type="domain.blog.Comment"/>
  <typeAlias alias="Post" type="domain.blog.Post"/>
  <typeAlias alias="Section" type="domain.blog.Section"/>
  <typeAlias alias="Tag" type="domain.blog.Tag"/>
</typeAliases>
```

在写`Mapper`的时候，就可以用类型简写，注意下面的`resultType`：

```xml
<select id="selectAll" resultType="Author">
    <!-- ... -->
</select>
```

想通过代码的形式实现`typeAliases`标签的功能，需要靠`TypeAliasRegistry`类，这个类实际上内部维护了一个`HashMap`，该类有两个核心方法：`registerAlias()`和`getTypeAliases()`

你可以通过下面的代码来注册一个别名：

```java
Class<?> clazz = ...;
TypeAliasRegistry typeAliasRegistry = configuration.getTypeAliasRegistry();
// 以短类名进行注册，或者如果标记了@Alias注解则使用注解起别名
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

```xml
<!-- mybatis-config.xml -->
<typeHandlers>
  <!-- 
	org.mybatis.example.ExampleTypeHandler是实现了TypeHandler接口的类 
  -->
  <typeHandler handler="org.mybatis.example.ExampleTypeHandler"/>
</typeHandlers>
```

方法类似于`typeAliases`，注册方法如下：

```java
configuration.getTypeHandlerRegistry().register(TypeHandler typehandler);
```

#### plugin标签

```xml
<plugins>
  <!-- org.mybatis.example.ExamplePlugin是实现了Interceptor接口的类 -->
  <plugin interceptor="org.mybatis.example.ExamplePlugin"></plugin>
</plugins>
```

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
unpooledDataSource.setPassword("root");
unpooledDataSource.setUsername("root");
Environment environment = new Environment(id, jdbcTransactionFactory, unpooledDataSource);
configuration.setEnvironment(environment);
```

对应的`XML`配置：

```xml
<environment id="dev">
        <transactionManager type="JDBC"></transactionManager>
        <dataSource type="UNPOOLED">
            <property name="url" value="jdbc:mysql://localhost:3306/sakila"/>
            <property name="username" value="root"/>
            <property name="password" value="root"/>
            <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
        </dataSource>
</environment>
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
