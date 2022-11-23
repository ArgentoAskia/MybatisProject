package dao2;

import bean.Salgrade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

public interface SalgradeDAO2 {

    @Insert("INSERT INTO salgrade(`LOSAL`, `HISAL`)\n" +
            "        VALUES(#{losal}, #{hisal})")
    @SelectKey(keyProperty = "grade", keyColumn = "GRADE",
            before = false, resultType = int.class,
            statement = "SELECT LAST_INSERT_ID()")
    int insert(Salgrade salgrade);
}
