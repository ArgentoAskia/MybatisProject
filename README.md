## mybatis-2-3-parameters

本章主要介绍`DAO`接口的参数传递给`Mapper`的几种方式，在`mybatis`中参数一般有下面几个类型：

- 基本类型、`String`、包装器类这些归为一类
- 引用类型
- `Map`

因此这些分类大概有`9`种组合。

在使用`JDBC`时候，都知道`Statement`一般会有两种：`statement`和`PreparedStatement`，其中`PreparedStatement`一般用于预处理的符号`?`（也叫占位符）的`SQL`语句，在`mybatis`中，处理`SQL`语句默认也是采用`PreparedStatement`（如果希望更改`SQL`执行器类型，可以指定`statementType`属性），但`mybatis`提供了一种新的占位符。

### mybatis的占位符

这里有一个非常简单的`DAO`接口：

```java
public interface ActorDAO{
    Actor selectById(Integer id);
}
```

非常简单的`DAO`，在`PreparedStatement`时代，这个`DAO`对应的`SQL`语句一般这样写：

```sql
SELECT * FROM actor where actor_id = ?
```

然后还需要编写者自己使用`preparedStatement.setXXX();`方法来填入参数。

在`mybatis`中就没有这么麻烦了，在`mybatis`中的占位符`#{}`可以让你省区调用烦人的`setXXX()`

例如上面的`DAO`，换成`Mapper`应该是这样写：

```xml
<select id="selectById" resultType="...">
    SELECT * FROM actor where actor_id = #{id}
</select>
```

注意看到那个`#{id}`了吗，在`mybatis`中这样就可以指定传递给`SQL`的参数，`#{}`里面的内容对应的是`DAO`中方法参数的参数名。