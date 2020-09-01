package edu.hebeu.util;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.util.Base64;

public class _3DESUtil {
    //private static String src = "cakin24 security 3des";
    //public static void main(String[] args) {
      //  jdk3DES();
    //}

    public static ReturnValue _3DESencrypt(String src) {

        ReturnValue rv = null;
        try {
            //生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            //keyGenerator.init(168);
            keyGenerator.init(new SecureRandom());//默认长度
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();
            //KEY转换
            DESedeKeySpec desedeKeySpec = new DESedeKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
            Key convertSecretKey = factory.generateSecret(desedeKeySpec);
            //加密
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());
            //System.out.println("jdk 3des encrypt : " + Base64.getEncoder().encodeToString(result));
            rv = new ReturnValue(convertSecretKey,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rv;
    }
}
