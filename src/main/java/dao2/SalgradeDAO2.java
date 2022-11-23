package dao2;

import bean.Salgrade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface SalgradeDAO2 {

    @Insert("INSERT INTO salgrade(`LOSAL`, `HISAL`)\n" +
            "        VALUES(#{losal}, #{hisal})")
    @Options(useGeneratedKeys = true,
            keyColumn = "GRADE",
            keyProperty = "grade")
    int insert(Salgrade salgrade);
}
