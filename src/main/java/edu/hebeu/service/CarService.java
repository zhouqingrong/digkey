package edu.hebeu.service;

import edu.hebeu.po.Car;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarService {
//    添加车辆
    public int addCar(Car car);
    //删除信息
    public int deleteCar(String carVIN);
    //查询信息
    public List<Car> findAllCars();
    //按车辆VIN查询
    public Car findCarByVIN(String carVIN);
}
