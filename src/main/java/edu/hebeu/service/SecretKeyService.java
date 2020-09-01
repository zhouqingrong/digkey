package edu.hebeu.service;


public interface SecretKeyService {
    //查询状态为1 的状态的秘钥对的公钥
    String findPublicKey();
}
