package edu.hebeu.service.impl;

import edu.hebeu.dao.CarCertDao;
import edu.hebeu.po.CarCert;
import edu.hebeu.service.CarCertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarCertServiceImpl implements CarCertService {
    @Autowired
    private CarCertDao carCertDao;
    @Override
    public int addCarCert(String carCertPath, String publicKey) {
        CarCert carCert = new CarCert();
        carCert.setCarCertPath(carCertPath);
        carCert.setCarPublicKey(publicKey);
        return carCertDao.addCarCert(carCert);
    }

    @Override
    public String findCarCertPath(String publicKey) {
        return carCertDao.findCarCertPath(publicKey);
    }
}
