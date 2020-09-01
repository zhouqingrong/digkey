package edu.hebeu.service.impl;

import edu.hebeu.dao.SecretKeyDao;
import edu.hebeu.service.SecretKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretKeyServiceImpl implements SecretKeyService {
    @Autowired
    private SecretKeyDao secretKeyDao;
    //查询tsp公钥
    @Override
    public String findPublicKey() {
        return secretKeyDao.findPublicKey();
    }
}
