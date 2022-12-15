package cn.argentoaskia.dao.support;

import cn.argentoaskia.bean.Category;
import cn.argentoaskia.dao.CategoryDAO;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class CategoryDAOSupport extends SqlSessionDaoSupport implements CategoryDAO {
    @Override
    public List<Category> selectAll() {
        return getSqlSession().getMapper(CategoryDAO.class).selectAll();
    }

    @Override
    public List<Category> selectById(Integer id) {
        return null;
    }
}
