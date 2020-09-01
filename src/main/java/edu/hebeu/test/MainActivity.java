package edu.hebeu.test;

import edu.hebeu.util.*;

import java.security.KeyPair;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import org.junit.Test;

class Message
{
    Message(int d,int f) {
        digitalKey = d;//数字钥匙
        flag = f;//指令
    }
    private int digitalKey;
    private int flag;
}
class SecretMessage
{
    SecretMessage(Message m,byte[] s) {
        message = m;//消息（明文指令、数字钥匙）
        sign = s;//数字签名
    }
    private Message message;
    private byte[] sign;
}

public class MainActivity {
    @Test
    public ReturnValue sendMsg(int digitalKey, int flag)
    {
        try{
            KeyPair keyPair = RSAUtil.getKeyPair();                                         //获取公私钥(实际应为从数据库中获取)
            String privateKeyStr = RSAUtil.getPrivateKey(keyPair);
            String publicKeyStr = RSAUtil.getPublicKey(keyPair);
            byte[] sign;

            Message message = new Message(digitalKey,flag);                                 //封装要发送的消息
            String hashValue = Md5Util.generateHash(message.toString());                    //hash运算，得到消息摘要

            PrivateKey privateKey = RSAUtil.string2Privatekey(privateKeyStr);
            sign = RSAUtil.sign(hashValue.getBytes(),privateKey);                          //私钥签名获得数字签名

            SecretMessage secretMessage = new SecretMessage(message,sign);                //获取要发送的信息（消息+数字签名）
            ReturnValue sendMessage = AESUtil.encode(secretMessage.toString()); //对称加密，得到密文+对称密钥
            /*****************************************
             *
             * 获得云端数字证书，对对称密钥进行加密.
             */
            /******************************************
             *
             *
             * 发送密文+加密后的对称密钥。
             */
            return sendMessage;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
