package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Actor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 简单介绍常见的四种分页查询，包括：
 * 1.业务层负责分页
 * 2.数据库limit关键字
 * 3.RowBounds实现
 * 4.PageHelper(插件)，感谢刘增辉老师，让我能够如此简单地学习mybatis
 */
public interface PageSelectDAO {

    // 业务层负责分页，具体模拟代码请看测试类
    List<Actor> selectPageByService();

    // 基于RowBounds的分页
    List<Actor> selectPageByRowBounds();

    // 基于limit关键字的分页
    List<Actor> selectPageByLimit(@Param("begin") int begin,@Param("limit") int limit);

    // 基于PageHelper插件的分页
    List<Actor> selectPageByPageHelper();
}
