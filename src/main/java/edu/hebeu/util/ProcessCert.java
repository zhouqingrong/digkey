package edu.hebeu.util;

import sun.misc.BASE64Encoder;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class ProcessCert {
    public static void main(String[] args){
        getPublicKeyFromCRT();
    }
    public static String getPublicKeyFromCRT(){
        String key = "";
        CertificateFactory certificatefactory;
        X509Certificate Cert;
        InputStream bais;
        PublicKey pk;
        BASE64Encoder bse;
        try{
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            //若此处不加参数 "BC"会报异常
            certificatefactory= CertificateFactory.getInstance("X.509","BC");
            //读取放在项目中assets文件夹下的.crt文件
            String fileName = "D:/文档/digitalkey/certstore/1.crt";
            //bais = this.getAssets().open("xxx.crt");
            bais = new BufferedInputStream(new FileInputStream(new File(fileName)));
            Cert = (X509Certificate) certificatefactory.generateCertificate(bais);
            pk = Cert.getPublicKey();
            bse = new BASE64Encoder();
            key = bse.encode(pk.getEncoded());
            System.out.println("源key-----"+ Cert.getPublicKey());
            System.out.println("加密key-----"+bse.encode(pk.getEncoded()));
        }catch(Exception e){
            e.printStackTrace();
        }
        key = key.replaceAll("\\n", "").trim();//去掉文件中的换行符
        return key;
    }


}
