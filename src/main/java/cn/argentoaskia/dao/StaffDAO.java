package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Staff;

import java.util.List;

public interface StaffDAO {
    List<Staff> selectAll();
}
