package dao;

import bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDAO {

    List<Emp> selectAllWithMySQL();
    List<Emp> selectByIdWithMySQL(@Param("empNo") Integer empNo);
    List<Emp> selectByENameWithMySQL(@Param("EName") String EName);
    List<Emp> selectByJobWithMySQL(@Param("job") String job);


    List<Emp> selectAllWithOracle();
    List<Emp> selectByIdWithOracle(@Param("empNo") Integer empNo);
    List<Emp> selectByENameWithOracle(@Param("EName") String EName);
    List<Emp> selectByJobWithOracle(@Param("job") String job);
}
