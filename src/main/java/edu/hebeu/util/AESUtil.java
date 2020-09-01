package edu.hebeu.util;

import org.apache.commons.codec.binary.Hex;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class AESUtil {
    public static Key key = null;

    public static Key getKey() {
        if (key != null) {
            return key;
        }
        byte[] keyBytes = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            keyBytes = secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return key;
        }
        key = new SecretKeySpec(keyBytes, "AES");
        return key;
    }

    //加密
    public static String encode(String value) {
        Key key = getKey();
        Cipher cipher;
        byte[] encodeResult = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encodeResult = cipher.doFinal(value.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return Hex.encodeHexString(encodeResult);
    }

    //解密
    public static String decode(String value) {
        Key key = getKey();
        Cipher cipher = null;
        byte[] decodeResult = null;
        String ret = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] test = Hex.decodeHex(value);
            decodeResult = cipher.doFinal(test);
            ret = new String(decodeResult, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static void main(String[] args) {
        String test = "hello world!";
        String ret = "";
        System.out.println(ret = AESUtil.encode(test));
        System.out.println(AESUtil.decode(ret));
    }

}
