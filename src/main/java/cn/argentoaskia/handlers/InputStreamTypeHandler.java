package cn.argentoaskia.handlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.InputStream;
import java.sql.*;

@MappedTypes(InputStream.class)
@MappedJdbcTypes(value = JdbcType.BLOB, includeNullJdbcType = true)
public class InputStreamTypeHandler implements TypeHandler<InputStream> {

    @Override
    public void setParameter(PreparedStatement ps, int i, InputStream parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("使用的TypeHandler：InputStreamtypeHandler" );
        System.out.println("JdbcType" + jdbcType.TYPE_CODE);
        ps.setBlob(i, parameter);
    }

    @Override
    public InputStream getResult(ResultSet rs, String columnName) throws SQLException {
        Blob blob = rs.getBlob(columnName);
        if (blob != null){
            InputStream binaryStream = blob.getBinaryStream();
            blob.free();
            return binaryStream;
        }
        return null;
    }

    @Override
    public InputStream getResult(ResultSet rs, int columnIndex) throws SQLException {
        Blob blob = rs.getBlob(columnIndex);
        if (blob != null){
            InputStream binaryStream = blob.getBinaryStream();
            blob.free();
            return binaryStream;
        }
        return null;
    }

    @Override
    public InputStream getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Blob blob = cs.getBlob(columnIndex);
        if (blob != null){
            InputStream binaryStream = blob.getBinaryStream();
            blob.free();
            return binaryStream;
        }
        return null;
    }
}
