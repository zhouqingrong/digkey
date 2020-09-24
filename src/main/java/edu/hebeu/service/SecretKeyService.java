package edu.hebeu.service;

import org.apache.ibatis.annotations.Param;

public interface SecretKeyService {
    //查询状态为1 的状态的秘钥对的公钥
    String findPublicKey();
    //查询状态为1 的状态的秘钥对的私钥
    String findPrivateKey();
    //增加tsp公钥
    int addTspSecretKey();
}
