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
    public int addUserCert(String userCertPath, String publicKey) {
        UserCert userCert = new UserCert();
        userCert.setUserCertPath(userCertPath);
        userCert.setUserPublicKey(publicKey);
        int flag = userCertDao.addUserCert(userCert);
        return flag;
    }
    //查询用户证书路径
    @Override
    public String findUserCertPath(String userPhone) {
        return userCertDao.findUserCertPath(userPhone);
    }


}
