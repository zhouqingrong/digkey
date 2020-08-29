package edu.hebeu.service.impl;

import edu.hebeu.dao.UserCertDao;
import edu.hebeu.po.UserCert;
import edu.hebeu.service.UserCertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserCertServiceImpl implements UserCertService {
    @Autowired
    private UserCertDao userCertDao;
    //添加用户证书
    @Override
    public int addUserCert(String userCertPath, String userPublicKey) {
        System.out.println("----------"+userCertPath+"----------"+userPublicKey);
        UserCert userCert = new UserCert();
        userCert.setUserCertPath(userCertPath);
        userCert.setUserPublicKey(userPublicKey);
        return userCertDao.addUserCert(userCert);
    }
    //查询用户证书路径
    @Override
    public String findUserCertPath(String userPublicKey) {
        return userCertDao.findUserCertPath(userPublicKey);
    }


}
