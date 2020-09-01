package edu.hebeu.service.impl;

import edu.hebeu.dao.CarDao;
import edu.hebeu.dao.KeyDao;
import edu.hebeu.po.Car;
import edu.hebeu.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;
    //添加车辆信息
    @Override
    public int addCar(Car car) {
        return carDao.addCar(car) ;
    }
//删除车辆信息
    @Override
    public int deleteCar(String carVIN) {
        return carDao.deleteCar(carVIN);
    }
//查询全部车辆信息
    @Override
    public List<Car> findAllCars() {
        return carDao.findAllCars();
    }

    @Override
    public Car findCarByVIN(String carVIN) {
        return carDao.findCarByVIN(carVIN);
    }

}
