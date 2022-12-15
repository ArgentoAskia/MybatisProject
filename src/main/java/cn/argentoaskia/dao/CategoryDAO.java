package cn.argentoaskia.dao;


import cn.argentoaskia.bean.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface CategoryDAO {
    List<Category> selectAll();
    List<Category> selectById(Integer id);
}
