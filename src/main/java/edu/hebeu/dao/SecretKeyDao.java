package edu.hebeu.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SecretKeyDao {
    //查询状态为1 的状态的秘钥对的公钥
    @Select("select tspPublicKey from secretkey where tspSecretKeyState = 1")
    String findPublicKey();
    //查询状态为1 的状态的秘钥对的私钥
    @Select("select tspPrivateKey from secretkey where tspSecretKeyState = 1")
    String findPrivateKey();
    //插入密钥信息
    @Insert("insert into secretkey(tspPublicKey,tspPrivateKey,tspSecretKeyState) values(#{tspPublicKey},#{tspPrivateKey},1)")
    int addTspSecretKey(@Param("tspPublicKey")String tspPublicKey,@Param("tspPrivateKey")String tspPrivateKey);
}
