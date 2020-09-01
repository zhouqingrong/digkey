package edu.hebeu.util;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtil {
    public final static byte[] getKey(){
        byte[] keyBytes = null;
        /* 生成Key */
        try {
            KeyGenerator keyGenerator = null;
            keyGenerator = KeyGenerator.getInstance("AES");
            //随机生成秘钥
            //keyGenerator.init(128);
            //生成固定的秘钥
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed("123456798".getBytes());
            keyGenerator.init(128, random);
            SecretKey secretKey = keyGenerator.generateKey();
            keyBytes = secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return keyBytes;
    }
//加密
    public static String checkAES(String value){    //value是你需要加密的字符串
        //调用生成秘钥方法
        Key key = new SecretKeySpec(ToolUtils.getKey(), "AES");
        //加密
        Cipher cipher = null;
        byte[] encodeResult = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encodeResult = cipher.doFinal(value.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return Hex.encodeHexString(encodeResult);
    }
    //解密
    public static String getAES(String value){           //value是需要解密的字符串
        //调用key的生成方法
        Key key = new SecretKeySpec(ToolUtils.getKey(), "AES");
        //解密
        Cipher cipher = null;
        byte[] decodeResult = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            //byte[] test = value.getBytes();
            byte[] test = Hex.decodeHex(token);
            decodeResult = cipher.doFinal(test);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        return (new String (decodeResult));
    }

}
