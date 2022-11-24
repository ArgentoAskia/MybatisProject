package cn.argentoaskia.dao;

import cn.argentoaskia.bean.Country;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountryCityDAO {

    List<Country> selectCountryAndItsCities();
}
