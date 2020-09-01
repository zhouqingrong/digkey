package edu.hebeu.util;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class AESUtil {

    public static Key getKey() {
        byte[] keyBytes = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            keyBytes = secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return new SecretKeySpec(keyBytes, "AES");
    }

    //加密
    public static ReturnValue encode(String value) {
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
        return new ReturnValue(key, encodeResult);
    }

    //解密
    public static String decode(ReturnValue value) {
        Key key = value.getKey();
        Cipher cipher = null;
        byte[] decodeResult = null;
        String ret = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] test = value.getBytes();
            decodeResult = cipher.doFinal(test);
            ret = new String(decodeResult, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
