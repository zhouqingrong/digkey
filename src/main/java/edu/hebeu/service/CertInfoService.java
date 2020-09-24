package edu.hebeu.service;

import edu.hebeu.po.CertInfo;
import org.apache.ibatis.annotations.Param;

public interface CertInfoService {
    //添加证书信息
    int addCertinfo(CertInfo certInfo);

    //从云端服务器上传手机公钥到ca服务器
    void sendPhonePublicKey(String userPhone, String publicKey) throws Exception;
}
