package edu.hebeu.service;

import edu.hebeu.po.UserCert;


public interface UserCertService {
    //添加用户证书
    int addUser(UserCert userCert);
    //按公钥查询用户证书
    UserCert findUserCertByUserPhone(String userPublicKey);
}
