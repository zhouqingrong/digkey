package edu.hebeu.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BindInfoDao {
    //新增绑定信息
    @Insert("insert into bindinfo(userPhone,carVIN) values(#{userPhone},#{carVIN})")
    int addBindInfo(@Param("userPhone")String userPhone,@Param("carVIN")String carVIN);
    //按手机号查询carVIN
    @Select("select carVIN from bindinfo where 1=1 and userPhone = #{userPhone}")
    String findCarVINByUserPhone(@Param("userPhone") String userPhone);
}
