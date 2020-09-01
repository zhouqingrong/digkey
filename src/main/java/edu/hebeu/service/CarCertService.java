package edu.hebeu.service;

public interface CarCertService {
    //添加车辆证书
    int addCarCert(String carCertPath,String carPublicKey,String carVIN);
    //按VIN查询车辆证书
    String findCarCertPath(String carVIN);
}
