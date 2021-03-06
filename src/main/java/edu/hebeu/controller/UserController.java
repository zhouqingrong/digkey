package edu.hebeu.controller;

import com.alibaba.fastjson.JSON;
import edu.hebeu.po.User;
import edu.hebeu.service.*;
import edu.hebeu.util.Result;
import edu.hebeu.util.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BindInfoService bindInfoService;
    @Autowired
    private KeyService keyService;//数字钥匙
    @Autowired
    private SecretKeyService secretKeyService;//云端密钥
    @Autowired
    private CarService carService;

    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    //注册（按手机号保持用户唯一）
    @RequestMapping(value="/register.do",method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user){
        try {
            if(userService.findUserByPhone(user.getUserPhone())==null){
                if(userService.addUser(user)==1){
                    return ResultUtil.success(secretKeyService.findPublicKey());
                }else {
                    log.info("注册失败");
                    return ResultUtil.error(1002,"注册失败");
                }
            }else {
                log.info("用户已存在");
                return ResultUtil.error(1001,"用户已存在");
            }
        } catch (Exception e) {
            log.error("注册出现异常",e);
            return ResultUtil.error(1003,"出现异常");
        }
    }
    //登录
    @RequestMapping(value="/login.do" ,method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User params){
        User user = null;
        try {
            System.out.println("表现层：用户登录...");
            user = userService.findUserByPhone(params.getUserPhone());
            if(user!=null){
                if(user.getUserPwd().equals(params.getUserPwd())){
                    userService.updateUserState(0,params.getUserPhone());
                    return ResultUtil.success(user);
                }else {
                    log.info("密码错误");
                    return ResultUtil.error(1002,"密码错误");
                }
            }else {
                log.info("查无此用户");
                return ResultUtil.error(1001,"查无此用户");
            }
        } catch (Exception e) {
            log.error("登录出现异常,用户：{}",JSON.toJSONString(user),e);
            return ResultUtil.error(1003,"出现异常");
        }
    }

    /**
     * 登出
     * @param userPhone
     * @return
     */
    @RequestMapping(value="/logout.do" )
    @ResponseBody
    public Result logout(@Param("userPhone") String userPhone){
        try {
            System.out.println("表现层：用户登出...");
            //查询用户是否为登录状态
            if(userService.findUserState(userPhone)==0){
                return ResultUtil.success(userService.updateUserState(1,userPhone));
            }else{
                return ResultUtil.error(1001,"用户非登录状态");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1003,"出现异常");
        }
    }

    /**
     * 注销账号
     * @param userPhone
     * @return
     */
    @RequestMapping(value="/close.do" )
    @ResponseBody
    public Result close(@Param("userPhone") String userPhone){
        try {
            System.out.println("表现层：用户注销账号...");
            //查询用户是否为登录状态
            if(userService.findUserState(userPhone)==0){
                return ResultUtil.success(userService.updateUserState(2,userPhone));
            }else{
                return ResultUtil.error(1001,"用户非登录状态");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1003,"出现异常");
        }
    }
    /**
     * 查询拥有车辆
     */
    @RequestMapping (value = "/findOwnCars.do")
    @ResponseBody
    public Result findOwnCars(@Param("userPhone") String userPhone){
        try {
            System.out.println("表现层：查询拥有车辆...");
            return ResultUtil.success(carService.findOwnCars(userPhone));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1003,"出现异常");
        }
    }
    /**
     * 添加绑定信息
     * @param
     * @return
     */
    @RequestMapping (value = "/addBindInfo.do")
    @ResponseBody
    public Result addBindInfo(@Param("userPhone")String userPhone,@Param("carVIN")String carVIN){
        try {
            if(userService.findUserState(userPhone)==0){
                System.out.println("表现层：添加绑定信息...");
                return ResultUtil.success(bindInfoService.addBindInfo(userPhone,carVIN));
            }else{
                return ResultUtil.error(1002,"用户非登录状态");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1003,"出现异常");
        }
    }

    /**
     * 按用户手机号查询钥匙
     */
    @RequestMapping (value = "/findKey.do")
    @ResponseBody
    public Result findKey(@Param("userPhone") String userPhone){
        try {
            System.out.println("表现层：接收钥匙...");
            return ResultUtil.success(keyService.findKey(userPhone));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1002,"出现异常");
        }
    }
    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping (value = "/addUser.do")
    @ResponseBody
    public Result addUser(@RequestBody User user){
        try {
            System.out.println("表现层：添加用户...");
            System.out.println(user);
            return ResultUtil.success(userService.addUser(user));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1002,"出现异常");
        }
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/findAllUsers.do",method = RequestMethod.GET)
    @ResponseBody
    public Result findAllUsers(){
        try {
            System.out.println("表现层：查询所有的用户...");
            return ResultUtil.success(userService.findAllUsers());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1002,"出现异常");
        }
    }

    /**
     * 按电话号码查询用户
     *  @param userPhone
     * @return
     */
    @RequestMapping(value = "/findUserByPhone.do",method = RequestMethod.GET)
    @ResponseBody
    public Result findUserByPhone(@Param("userPhone") String userPhone){
        try {
            System.out.println("表现层：按电话号码查询用户...");
            return ResultUtil.success(userService.findUserByPhone(userPhone));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1003,"出现异常");
        }
    }

    /**
     * 按id查询用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findUserById.do",method = RequestMethod.GET)
    @ResponseBody
    public Result findUserById(@Param("userId") int userId){
        try {
            System.out.println("表现层：按id查询用户...");
            User user = userService.findUserById(userId);
            System.out.println(user);
            return ResultUtil.success(userService.findUserById(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1002,"出现异常");
        }
    }

    /**
     * 按用户名模糊查询用户
     * @param userName
     * @return
     */
    @RequestMapping(value = "/findUsersByName.do",method = RequestMethod.GET)
    @ResponseBody
    public Result findUsersByName(@Param("userName") String userName){
        try {
            System.out.println("表现层：按用户名模糊查询用户...");
            return ResultUtil.success(userService.findUsersByName(userName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1002,"出现异常");
        }
    }
}
