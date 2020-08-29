package edu.hebeu.controller;

import com.alibaba.fastjson.JSONObject;
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
@RequestMapping("/userCert")
public class FileController {
    @Autowired
    private UserCertService userCertService;
    //   保存文件
    @RequestMapping(value = "/uploadUserCert.do",method = RequestMethod.POST)
    @ResponseBody
    public Result uploadUserCert(@RequestParam MultipartFile file, @Param("userPublicKey")String userPublicKey){
        System.out.println(userPublicKey);
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
                userCertService.addUserCert(filepath.getAbsolutePath(),userPublicKey);
                return ResultUtil.success(processData);
            }else{
                return ResultUtil.error(0,"file is null");
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return ResultUtil.error(0,"upload error");
        }
    }

    //提供文件下载
    @RequestMapping(value = "/downloadUserCert.do", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> downloadUserCert(@RequestParam String userPublicKey){
        try{
            // 下载文件路径
           String filePath = userCertService.findUserCertPath(userPublicKey);
            // 获得要下载文件的File对象
            File file = new File(filePath);
            // 创建springframework的HttpHeaders对象
            HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
        }
        catch (Exception e){
            return null;
        }
    }
}
