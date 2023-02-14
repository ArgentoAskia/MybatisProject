package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> selectByConditions(Customer customer);
}
