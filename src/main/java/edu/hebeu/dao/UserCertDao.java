package edu.hebeu.dao;

import edu.hebeu.po.UserCert;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface  UserCertDao {
    //添加用户证书
    @Insert("insert into usercert(userCertPath,userCertUpdateTime,userCertState,userPublicKey) values(#{userCert.userCertPath},#{userCert.userCertUpdateTime},#{userCert.userCertState},#{userCert.userPublicKey})")
    int addUser(@Param("userCert")UserCert userCert);
    //按公钥查询用户证书
    @Select("select * from usercert where 1=1 and userPublicKey  =  #{userPublicKey}")
    UserCert findUserCertByUserPhone(@Param("userPublicKey") String userPublicKey);
}
