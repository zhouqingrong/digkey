package edu.hebeu.service.impl;


import com.jcraft.jsch.ChannelSftp;
import edu.hebeu.dao.CertInfoDao;
import edu.hebeu.po.CertInfo;
import edu.hebeu.service.CertInfoService;
import edu.hebeu.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class CertInfoServiceImpl implements CertInfoService {
    @Autowired
    private CertInfoDao certInfoDao;
    @Override
    public int addCertinfo(CertInfo certInfo) {
        return certInfoDao.addCertInfo(certInfo);
    }

    //从云端服务器上传手机公钥到ca服务器
    @Override
    public void sendPhonePublicKey(String userPhone, String publicKey) throws Exception {
        //云端存储公钥的路径
        String yunfilepath = "/usr/local/tomcat/digkey/phone/" + userPhone + "/";
//        String yunfilepath = "F:\\digkey\\phone\\" + userPhone + "\\";
        //ca端存储公钥的路径
        String cafilepath = "/root/digkey/phone/" + userPhone + "/";
        File filedir = new File(yunfilepath);
        //如果云端文件夹不存在则创建
        if  (!filedir .exists()  && !filedir .isDirectory())
        {
            System.out.println("不存在");
            filedir .mkdir();
        } else
        {
            System.out.println("目录存在");
        }
        //String yunpath = "/root/digkey/phone/" + userPhone + "/";
        //String capath = "/root/digkey/phone/" + userPhone + "/";
        String filePath = yunfilepath + "publickey.txt";
        File file = new File(filePath);
        //如果云端公钥文件不存在则创建
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //把手机端传来的用户信息和公钥写入文件
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            String s = userPhone + "\n" + publicKey;
            fos.write(s.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChannelSftp ftpClient = FtpUtil.getConnect("123.57.133.103", "22", "root", "12345678Aa");
        FtpUtil.uploadFile(filePath,cafilepath,"publickey.txt");
        FtpUtil.close();
//从ca服务器下载证书到云端服务器
        ChannelSftp ftpClient1 = FtpUtil.getConnect("123.57.133.103", "22", "root", "12345678Aa");
        String capath = "/root/digkey/phone/" + userPhone + "/";
        String yunpath = "/usr/local/tomcat/digkey/phone/" + userPhone + "/";
        FtpUtil.download(capath, yunpath,"1.cer", "1.cer");
        FtpUtil.close();

    }

}
