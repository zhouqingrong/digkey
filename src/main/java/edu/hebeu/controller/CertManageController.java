package edu.hebeu.controller;

import com.alibaba.fastjson.JSONObject;
import edu.hebeu.service.CarCertService;
import edu.hebeu.service.UserCertService;
import edu.hebeu.util.Result;
import edu.hebeu.util.ResultUtil;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    //   保存文件
    @RequestMapping(value = "/uploadCert.do",method = RequestMethod.POST)
    @ResponseBody
    public Result uploadUserCert(@RequestParam MultipartFile file, @Param("PublicKey")String publicKey,@Param("role")int role){
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
                if(role == 1){//app用户role为1
                    if(userCertService.addUserCert(filepath.getAbsolutePath(),publicKey)==1)
                        return ResultUtil.success();
                }else if(role == 0){
                    if(carCertService.addCarCert(filepath.getAbsolutePath(),publicKey)==1)
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

    //提供用户证书下载
    @RequestMapping(value = "/downloadUserCert.do", method = RequestMethod.GET)
    @ResponseBody
    public Result downloadUserCert(@RequestParam String userPhone){
        try{
            // 下载文件路径
           String filePath = userCertService.findUserCertPath(userPhone);
            // 获得要下载文件的File对象
            File file = new File(filePath);
            // 创建springframework的HttpHeaders对象
            HttpHeaders headers = new HttpHeaders();
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
            return ResultUtil.success(responseEntity);
        }
        catch (Exception e){
            return ResultUtil.error(1003,"出现异常");
        }
    }
}
