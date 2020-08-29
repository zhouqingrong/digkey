package edu.hebeu.dao;

import edu.hebeu.po.Car;
import edu.hebeu.po.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarDao {
    //增添车辆信息
    @Insert("insert into car(carVIN,carType,carColor,carCreateDate) values(#{car.carVIN},#{car.carType},#{car.carColor},#{car.carCreateDate})")
    public int addCar(@Param("car")Car car);
    //删除信息
    @Delete("delete from car where carVIN = #{carVIN}")
    public int deleteCar(@Param("carVIN") String carVIN);
    //查询信息
    @Select("select * from car")
    public List<Car> findAllCars();
    //按车辆VIN查询
    @Select("select * from car where carVIN = #{carVIN}")
    public Car findCarByVIN(@Param("carVIN") String carVIN);

}
