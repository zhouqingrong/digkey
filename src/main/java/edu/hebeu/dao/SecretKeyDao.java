package edu.hebeu.dao;

import org.apache.ibatis.annotations.Select;

public interface SecretKeyDao {
    //查询状态为1 的状态的秘钥对的公钥
    @Select("select tspPublicKey from secretKey where tspSecretKeyState = 1")
    String findPublicKey();
    //查询状态为1 的状态的秘钥对的私钥
    @Select("select tspPrivateKey from secretKey where tspSecretKeyState = 1")
    String findPrivateKey();
    //插入密钥信息
}
