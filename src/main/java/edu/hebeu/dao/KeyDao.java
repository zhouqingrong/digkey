package edu.hebeu.dao;

import edu.hebeu.po.Key;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface KeyDao {
    //新增钥匙
    @Insert("insert into key(keyNumber,carVIN,keyState) values(#{key.keyNumber},#{key.carVIN},#{key.keyState})")
    int addKey(@Param("key")Key key);
    //按carVIN查询钥匙
    @Select("select * from key where 1=1 and carVIN = #{carVIN}")
    Key findKeyByCarVIN(@Param("carVIN")String carVIN);
}
