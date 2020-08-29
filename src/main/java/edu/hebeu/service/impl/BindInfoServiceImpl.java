package edu.hebeu.service.impl;

import edu.hebeu.dao.BindInfoDao;
import edu.hebeu.service.BindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BindInfoServiceImpl implements BindInfoService {
    @Autowired
    private BindInfoDao bindInfoDao;
    @Override
    public int addBindInfo(String userPhone, String carVIN) {
        return bindInfoDao.addBindInfo(userPhone,carVIN);
    }
}
