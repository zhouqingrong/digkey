package edu.hebeu.dao;

import edu.hebeu.po.CarCert;
import edu.hebeu.po.UserCert;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CarCertDao {
    //添加车端证书
    @Insert("insert into carcert(carCertPath,carCertUpdateTime,carCertState,carPublicKey) values(#{carCert.carCertPath},now(),1,#{carCert.carPublicKey})")
    int addCarCert(@Param("carCert") CarCert carCert);
    //按公钥查询车证书
    @Select("select carCertPath from carcert where 1=1 and carPublicKey = #{publicKey}")
    String findCarCertPath(@Param("publicKey") String publicKey);
    //按carVIN查询公钥
    @Select("select carPublicKey from carcert where 1=1 and carVIN = #{carVIN}")
    String findCarPublicKey(@Param("carVIN")String carVIN);
}
