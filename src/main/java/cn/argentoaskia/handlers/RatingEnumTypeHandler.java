package cn.argentoaskia.handlers;


import cn.argentoaskia.enums.Rating;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingEnumTypeHandler extends org.apache.ibatis.type.EnumTypeHandler<Rating>{

    public RatingEnumTypeHandler() {
        super(Rating.class);
    }

    @Override
    public Rating getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String s = rs.getString(columnIndex);
        if (s.contains("-")){
            String replace = s.replace("-", "_");
            return Enum.valueOf(Rating.class, replace);
        }
        return super.getNullableResult(rs, columnIndex);
    }

    @Override
    public Rating getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        if (s.contains("-")){
            String replace = s.replace("-", "_");
            return Enum.valueOf(Rating.class, replace);
        }
        return super.getNullableResult(rs, columnName);
    }

    @Override
    public Rating getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String s = cs.getString(columnIndex);
        if (s.contains("-")){
            String replace = s.replace("-", "_");
            return Enum.valueOf(Rating.class, replace);
        }
        return super.getNullableResult(cs, columnIndex);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Rating parameter, JdbcType jdbcType) throws SQLException {
        if (parameter.name().contains("_")){
            String replace = parameter.name().replace("_", "-");
            if (jdbcType == null) {
                ps.setString(i, replace);
            } else {
                ps.setObject(i, replace, jdbcType.TYPE_CODE); // see r3589
            }
        }
        else super.setNonNullParameter(ps, i, parameter, jdbcType);
    }
}
