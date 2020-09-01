package edu.hebeu.dao;

import edu.hebeu.po.UserCert;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface  UserCertDao {
    //添加用户证书
    @Insert("insert into usercert(userCertPath,userCertUpdateTime,userCertState,userPublicKey) values(#{userCert.userCertPath},now(),1,#{userCert.userPublicKey})")
    int addUserCert(@Param("userCert") UserCert userCert);
    //按账号查询用户证书
    @Select("select userCertPath from usercert where 1=1 and userPhone  =  #{userPhone}")
    String findUserCertPath(@Param("userPhone") String userPhone);
    //按手机号查询公钥
    @Select("select userPublicKey from usercert where 1=1 and userPhone = #{userPhone}")
    String findUserPublicKey(@Param("userPhone")String userPhone);
}
