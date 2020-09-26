package edu.hebeu.controller;

import com.alibaba.fastjson.JSONObject;
import edu.hebeu.po.User;
import edu.hebeu.service.CarCertService;
import edu.hebeu.service.CertInfoService;
import edu.hebeu.service.UserCertService;
import edu.hebeu.service.UserService;
import edu.hebeu.util.FileReaderUtil;
import edu.hebeu.util.ObjectUtil;
import edu.hebeu.util.Result;
import edu.hebeu.util.ResultUtil;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/cert")
public class CertManageController {
    @Autowired
    private UserCertService userCertService;
    @Autowired
    private CarCertService carCertService;
    @Autowired
    private UserService userService;
    @Autowired
    private CertInfoService certInfoService;

    public static final Logger log = LoggerFactory.getLogger(CertManageController.class);

    //校验手机端申请信息
    @RequestMapping(value="/compInfo.do",method = RequestMethod.POST)
    @ResponseBody
    public Result compInfo(@RequestBody User user){
        try {
            User u = userService.findUserByPhone(user.getUserPhone());
            if(u!=null){
                if(userService.findUserState(u.getUserPhone())==0){
                    if(u.getUserPwd().equals(user.getUserPwd()) && u.getUserName().equals(user.getUserName()) && u.getUserNumber().equals(u.getUserNumber())){
                        certInfoService.sendPhonePublicKey(user.getUserPhone(),user.getUserPublicKey());
                        return ResultUtil.success();
                    }else {
                        log.info("用户信息不合法");
                        return ResultUtil.error(1002,"用户信息不合法");
                    }
                }else{
                    log.info("用户未处于正常登录状态");
                    return ResultUtil.error(1004,"用户未处于正常登录状态");
                }
            }else {
                log.info("用户尚未注册");
                return ResultUtil.error(1001,"用户尚未注册");
            }
        } catch (Exception e) {
            log.error("出现异常",e);
            return ResultUtil.error(1003,"出现异常");
        }
    }

    /**
     * @param file 要保存的文件
     * @param publicKey 公钥
     * @param role 唯一标识
     * @param flag 区分标志 1用户 0车
     * @return
     */
    //   保存文件
    @RequestMapping(value = "/uploadCert.do",method = RequestMethod.POST)
    @ResponseBody
    public Result uploadUserCert(@RequestParam MultipartFile file, @Param("publicKey")String publicKey,@Param("role")String role,@Param("flag")int flag){
        System.out.println(publicKey);
        //        设置过程数据
        JSONObject processData = new JSONObject();
        try{
            // 如果文件不为空，写入上传路径
            if(!file.isEmpty()){
                // 定义上传文件路径
                String path = "F:\\digkey";
                String fileId = String.valueOf(System.currentTimeMillis());
                // 上传文件名
                String filename = fileId + "-" + file.getOriginalFilename();
                processData.put("filename",filename);
                processData.put("filepath","/file/download?fileName="+filename);
                File filepath = new File(path,filename);
//                System.out.println(UUID.randomUUID().toString());
                // 判断路径是否存在，如果不存在就创建一个
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                // 将上传文件保存到一个目标文件当中
                file.transferTo(new File(path+File.separator+ filename));
                System.out.println("----------"+filepath.getAbsolutePath());
                if(flag == 1){//app用户flag为1
                    if(userCertService.addUserCert(filepath.getAbsolutePath(),publicKey,role)==1)
                        return ResultUtil.success();
                }else if(flag == 0){
                    if(carCertService.addCarCert(filepath.getAbsolutePath(),publicKey,role)==1)
                        return ResultUtil.success();
                }
                return ResultUtil.error(1001,"保存失败");
            }else{
                return ResultUtil.error(1002,"文件为空");
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return ResultUtil.error(1003,"出现异常");
        }
     }
    /**
     * //提供用户证书下载
     * @param role 唯一标识
     * @param flag 1为用户 0为车
     * @return
     */
    @RequestMapping(value = "/downloadUserCert.do", method = RequestMethod.GET)
    @ResponseBody
    public Result downloadUserCert(@Param("role") String role,@Param("flag")int flag){
        try{
            String filePath = "/usr/local/tomcat/digkey/";
//            String filePath = "F:\\digkey\\phone\\";
//            String filePath =userCertService.findUserCertPath(role);//默认为用户
            // 下载文件路径
            if(flag==1){//flag==1 为用户
//                filePath = userCertService.findUserCertPath(role);
                filePath = filePath+"phone/"+role+"/"+role+".crt";
                System.out.println(filePath);
            }else if(flag == 0){
                filePath =carCertService.findCarCertPath(role);
            }
            System.out.println("路径："+filePath);
            // 获得要下载文件的File对象
            File file = new File(filePath);
//            System.out.println(FileReaderUtil.readFileContent(file.getName()));
            // 创建springframework的HttpHeaders对象
            HttpHeaders headers = new HttpHeaders();
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
            return ResultUtil.success(responseEntity);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(1003,"出现异常");
        }
    }
}
