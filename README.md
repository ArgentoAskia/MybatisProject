## Mybatis框架知识点大纲

- [x] 1. `Mybatis`快速上手：

- [ ] 2. `Mybatis`的基本使用方法：
     1. `mybatis-config`的配置方式
        - [x] `XML`方式
        - [x] 代码方式
     2. `mybatis-mapper`的写法（基本CRUD）
        - [x] `XML`方式
        - [x] 注解方式
        - [x] `Provider`方式
     3. 参数传递的方式
        - [x] 单参数+基本类型（包装器）
        - [x] 单参数+实体类
        - [x] 单参数+`Map`
        - [x] 多参数+基本类型（包装器）
        - [x] 多参数+多个实体类
        - [x] 多参数+`Map`
     4. `ResultMap`
        - [x] 解决实体类字段和结果集表字段名不一致问题（`SQL`重命名解法、`ResultMap`解法）
          - [x] `XML`形式
          - [x] 注解形式
        - [x] 简单表级联查询（`SQL`重命名解法、`ResultMap`解法）
          - [x] `XML`形式
          - [x] 注解形式
        - [ ] `ResultMap`继承
          - [ ] `XML`形式
          - [ ] 注解形式

- [ ] 3. `Mybatis`动态SQL
     - [x] `if`：判断标签
     - [x] `choose`：多选标签
     - [x] `where`：条件查询
     - [x] `set`：局部更新字段
     - [x] `foreach`：批量插入数据
     - [ ] `bind`：
     - [x] `trim`：前后缀拼接标签
     - [ ] `OGNL`表达式

- [ ] 4. `Mybatis`复杂查询

     - [x] 1. 返回自增主键

       - [x] `JDBC`方式
       - [x] `select key`方式

     - [x] 2. 多数据库支持

     - [X] 3. 高级映射
          1. 一对一查询
             - [x] `SQL`字段重命名法
             - [x] `resultmap`法
             - [x] `association`标签
          2. 一对多查询
             - [x] `collection`标签
          3. 多对多查询
             - [x] `collection`标签
          4. 鉴别器查询
             - [x] `discriminator`标签
     
     - [x] 4. TypeHandler
     - [x] 5. PageSelected分页查询

- [ ] 5. `Mybatis`缓存介绍
     - [ ] 一级缓存
     - [ ] 二级缓存
       - [ ] 配置二级缓存
       - [ ] 使用二级缓存
       - [ ] 二级缓存适用场景
     - [ ] 集成`EhCache`缓存
     - [ ] 集成`Redis`缓存
     - [ ] 如何避免脏数据

- [ ] 6. `Mybatis`插件开发
     - [ ] 拦截器介绍
     - [ ] 拦截器签名
       - [ ] `Executor`接口
       - [ ] `ParameterHandler`接口
       - [ ] `ResultSetHandler`接口
       - [ ] `StatementHandler`接口
     - [ ] 应用
       - [ ] 下划线转驼峰映射插件
       - [ ] 分页插件

- [ ] 7. `Mybatis`详细资料
     1. `mybatis-config`配置文件标签介绍
        - [ ] `properties`
        - [ ] `settings`
        - [ ] `typeAliases`
        - [ ] `typeHandlers`
        - [ ] `objectFactory`
        - [ ] `plugins`
        - [ ] `environments`
        - [ ] `databaseIdProvider`
        - [ ] `mappers` 
     2. `mybatis-mapper`配置
        1. 基于注解的配置
     3. `Java API`
        - [ ] `mybatis-test-API`
        - [ ] `SQL`语句构建器
        - [ ] 日志配置

- [ ] 8. 框架整合
     - [x] 1. `Mybatis-Spring`整合：unknown、2023.1.12、2023.1.13
     - [ ] 2. `Mybatis-SpringBoot`整合

## 更新日志

- 2023.02.07 - 添加多参数传递：基本类型+POJO的三种处理方式

------

- 2023.02.06 - 添加Mapper和Mybatis-config区别说明

------

- 2023.02.01 - 更新mybatis-2-1-README

-------

- 2023.01.13 - 解决注解形式配置抛出无法找到实体类Actor的问题

- 2023.01.13 - 更新spring-mybatis整合笔记

-----

- 2023.01.12 - 更新Mybatis-Spring框架整合笔记

------

- 未知更新时间 - 更新Mybatis整体demo 