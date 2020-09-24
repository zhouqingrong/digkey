package edu.hebeu.controller;

import com.jcraft.jsch.ChannelSftp;
import edu.hebeu.po.CertInfo;
import edu.hebeu.service.CertInfoService;
import edu.hebeu.util.FtpUtil;
import edu.hebeu.util.ProcessCert;
import edu.hebeu.util.Result;
import edu.hebeu.util.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cert")

public class CertController {

    @Autowired
    private CertInfoService certInfoService;

    /*
    获取公钥key（读取.crt认证文件）
    */
    @RequestMapping("/getpublickey.do")
    public void getPublicKey(){
        ProcessCert.getPublicKeyFromCRT();
    }



    //获取云端证书
    @RequestMapping("/getyuncert.do")
    public void getYunCert() throws Exception {

       //从ca服务器下载云端证书到云端服务器
        ChannelSftp ftpClient = FtpUtil.getConnect("123.57.133.103", "22", "root", "12345678Aa");
        String capath = "/root/digkey/yun";
        String yunpath = "/usr/local/tomcat/digkey/yun";
        FtpUtil.download(capath, yunpath,"1.cer","yun.cer");
        FtpUtil.close();
    }

    //发送公钥生成云端证书（唯一）
    @RequestMapping("/sendpublickey.do")
    public void sendPublicKey() throws Exception {
        //将云端公钥上传到ca服务器
        ChannelSftp ftpClient = FtpUtil.getConnect("123.57.133.103", "22", "root", "12345678Aa");
        String capath = "/root/digkey/yun";
        String yunpath = "/usr/local/tomcat/digkey/yun/publickey.txt";
        FtpUtil.uploadFile(yunpath,capath,"publickey.txt");
        FtpUtil.close();
    }
    //获取手机端证书
    @RequestMapping("/getphonecert.do")
    public Result getPhoneCert(@Param("userPhone") String userPhone,@Param("certName") String certName) throws Exception {
        //从ca服务器下载证书到云端服务器
        ChannelSftp ftpClient = FtpUtil.getConnect("123.57.133.103", "22", "root", "12345678Aa");
        String capath = "/root/digkey/phone/" + userPhone + "/";
        String yunpath = "/usr/local/tomcat/digkey/phone/" + userPhone + "/";
        FtpUtil.download(capath, yunpath,"1.cer", certName);
        FtpUtil.close();
        CertInfo certInfo = new CertInfo(certName,userPhone);
        return ResultUtil.success(certInfoService.addCertinfo(certInfo));
    }

}
