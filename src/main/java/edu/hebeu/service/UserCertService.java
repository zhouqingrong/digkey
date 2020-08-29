package edu.hebeu.service;

import edu.hebeu.po.UserCert;
import org.springframework.web.multipart.MultipartFile;

public interface UserCertService {
    //添加用户证书
    int addUserCert(String userCertPath,String userPublicKey);
    //按公钥查询用户证书
    String findUserCertPath(String userPublicKey);
}
