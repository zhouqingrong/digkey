package edu.hebeu.service.impl;

import edu.hebeu.dao.SecretKeyDao;
import edu.hebeu.service.SecretKeyService;
import edu.hebeu.util.RSAUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

@Service
public class SecretKeyServiceImpl implements SecretKeyService {
    @Autowired
    private SecretKeyDao secretKeyDao;
    //查询tsp公钥
    @Override
    public String findPublicKey() {
        return secretKeyDao.findPublicKey();
    }
    //查询私钥
    @Override
    public String findPrivateKey() {
        return secretKeyDao.findPrivateKey();
    }
    //生成公私钥
    @Override
    public int addTspSecretKey() {
        KeyPair keyPair = null;                                         //获取公私钥(实际应为从数据库中获取)
        try {
            keyPair = RSAUtil.getKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String tspPrivateKey = RSAUtil.getPrivateKey(keyPair);
        String tspPublicKey = RSAUtil.getPublicKey(keyPair);
        return secretKeyDao.addTspSecretKey(tspPublicKey,tspPrivateKey);
    }
}
