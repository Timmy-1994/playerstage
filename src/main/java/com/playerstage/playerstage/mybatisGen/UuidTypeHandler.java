package com.playerstage.playerstage.mybatisGen;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

public class UuidTypeHandler extends BaseTypeHandler<UUID> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int columnIndex, UUID uuid, JdbcType jdbcType)
      throws SQLException {

    long mostBit = uuid.getMostSignificantBits();
    byte[] bytes = new byte[16];
    bytes[0] = (byte) ((mostBit >> 56) & 0xFF);
    bytes[1] = (byte) ((mostBit >> 48) & 0xFF);
    bytes[2] = (byte) ((mostBit >> 40) & 0xFF);
    bytes[3] = (byte) ((mostBit >> 32) & 0xFF);
    bytes[4] = (byte) ((mostBit >> 24) & 0xFF);
    bytes[5] = (byte) ((mostBit >> 16) & 0xFF);
    bytes[6] = (byte) ((mostBit >> 8) & 0xFF);
    bytes[7] = (byte) (mostBit & 0xFF);
    //
    long leastBit = uuid.getLeastSignificantBits();
    bytes[8] = (byte) ((leastBit >> 56) & 0xFF);
    bytes[9] = (byte) ((leastBit >> 48) & 0xFF);
    bytes[10] = (byte) ((leastBit >> 40) & 0xFF);
    bytes[11] = (byte) ((leastBit >> 32) & 0xFF);
    bytes[12] = (byte) ((leastBit >> 24) & 0xFF);
    bytes[13] = (byte) ((leastBit >> 16) & 0xFF);
    bytes[14] = (byte) ((leastBit >> 8) & 0xFF);
    bytes[15] = (byte) (leastBit & 0xFF);
    //
    ps.setBytes(columnIndex, bytes);
  }

  @Override
  public UUID getNullableResult(ResultSet rs, String columnName) throws SQLException {
    byte[] bytes = rs.getBytes(columnName);

    long mostBit = ((((long) bytes[0] & 0xFF) << 56) | (((long) bytes[1] & 0xFF) << 48)
        | (((long) bytes[2] & 0xFF) << 40) | (((long) bytes[3] & 0xFF) << 32) | (((long) bytes[4] & 0xFF) << 24)
        | (((long) bytes[5] & 0xFF) << 16) | (((long) bytes[6] & 0xFF) << 8) | (((long) bytes[7] & 0xFF)));

    long leastBit = ((((long) bytes[8] & 0xFF) << 56) | (((long) bytes[9] & 0xFF) << 48)
        | (((long) bytes[10] & 0xFF) << 40) | (((long) bytes[11] & 0xFF) << 32) | (((long) bytes[12] & 0xFF) << 24)
        | (((long) bytes[13] & 0xFF) << 16) | (((long) bytes[14] & 0xFF) << 8) | (((long) bytes[15] & 0xFF)));
    return new UUID(mostBit, leastBit);
  }

  @Override
  public UUID getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return null;
  }

  @Override
  public UUID getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return null;
  }
}