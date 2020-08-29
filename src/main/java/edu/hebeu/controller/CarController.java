package edu.hebeu.controller;

import edu.hebeu.po.Car;
import edu.hebeu.service.CarService;
import edu.hebeu.util.Result;
import edu.hebeu.util.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 添加车辆信息
     * @param car
     * @return
     */
    @RequestMapping (value = "/addCar.do")
    @ResponseBody
    public Result addUser(@RequestBody Car car){
        try {
            System.out.println("表现层：添加车辆...");
            System.out.println(car);
            return ResultUtil.success(carService.addCar(car));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1002,"出现异常");
        }
    }
    /**
     * 删除车辆信息
     * @param carVIN
     * @return
     */
    @RequestMapping (value = "/deleteCar.do")
    @ResponseBody
    public Result deleteCar(@Param("carVIN") String carVIN){
        try {
            System.out.println("表现层：删除车辆...");
            System.out.println(carVIN);
            return ResultUtil.success(carService.deleteCar(carVIN));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1002,"出现异常");
        }
    }

    /**
     * 查询车辆信息
     * @param
     * @return
     */
    @RequestMapping (value = "/findAllCars.do")
    @ResponseBody
    public Result findAllCars(){
        try {
            System.out.println("表现层：查询车辆...");
            return ResultUtil.success(carService.findAllCars());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1002,"出现异常");
        }
    }
    /**
     * 按VIN查询车辆信息
     * @param carVIN
     * @return
     */
    @RequestMapping (value = "/findCarByVIN.do")
    @ResponseBody
    public Result findCarByVIN(@Param("carVIN") String carVIN){
        try {
            System.out.println("表现层：按VIN码查询车辆...");
            return ResultUtil.success(carService.findCarByVIN(carVIN));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1002,"出现异常");
        }
    }
}
