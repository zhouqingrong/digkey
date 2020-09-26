package edu.hebeu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.hebeu.dao.BindInfoDao;
import edu.hebeu.dao.CarCertDao;
import edu.hebeu.dao.SecretKeyDao;
import edu.hebeu.dao.UserCertDao;
import edu.hebeu.service.MessageService;
import edu.hebeu.util.*;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;



@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private SecretKeyDao secretKeyDao;
    @Autowired
    private UserCertDao userCertDao;
    @Autowired
    private CarCertDao carCertDao;
    @Autowired
    private BindInfoDao bindInfoDao;
    //接收消息解密
    @Override
    public String receiveMessage(String message, String secretKey,String userPhone) throws Exception {
        //获取tsp私钥
        String tspPrivateKey = secretKeyDao.findPrivateKey();
        //获取app端用户公钥
//      String userPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCczLrYcPeoWEnqvZXqUSLETlLHGjVXpoyAYpiLN+ENAGrziCDpZpx1oRS3lTf3GlZDr0FOJfPeJToIqelvGtr5KBYCmYzVhIYXn9a4nP6Y04QJjFeJNxnhzios27K6agn32rsghrOEpa5+HZZF4znSpQg3vOEkpX198pX/5HFK0QIDAQAB";
        String userPublicKey = userCertDao.findUserPublicKey(userPhone);
        //1.拿到字符数组的密文、加密后的对称密钥
//       Key AESKey = message.getKey();
       byte[] secretMsg = message.getBytes("ISO-8859-1");
       byte[] secretK = secretKey.getBytes("ISO-8859-1");
        //2.云端私钥解密，拿到对称密钥
        byte[] K = RSAUtil.privateDecrypt(secretK,RSAUtil.string2Privatekey(tspPrivateKey)); //获取对称密钥K
        System.out.println("解密后的对称密钥:"+UtilHelper.byte2Base64StringFun(K));
        //3.使用对称密钥解密 加密的信息，拿到明文消息、数字签名
        String Amessage = AESUtil.decode(new String(secretMsg, "ISO8859-1"),AESUtil.byte2Key(K));  //用K对密文进行解密，得到数字信息和数字签名
//        System.out.println("消息+数字签名:"+Amessage);
        //4.分解开明文、数字签名。并打印
        JSONObject jsonbject = JSON.parseObject(Amessage);
        JSONObject jsonMessage = jsonbject.getJSONObject("message");
        System.out.println("收到的消息为:"+jsonMessage);//明文
        String jsonsign = jsonbject.getString("sign");
        System.out.println("收到的数字签名为:"+jsonsign);
        //5.对数字签名：使用app公钥解密，拿到摘要
        byte[] jsonsign1  = Base64.getDecoder().decode(jsonsign);
        byte[] jsonhash = RSAUtil.verify(jsonsign1,RSAUtil.string2PublicKey(userPublicKey));
        System.out.println("解密后的 hash值："+new  String(jsonhash));
        //6.计算hash值摘要2
        System.out.println("明文运算："+Md5Util.generateHash(jsonMessage.toString()));
        //7.比对两摘要
        if(Md5Util.generateHash(jsonMessage.toString()).equals(new  String(jsonhash))) //hash运算与信息摘要对比
        {
            System.out.println("验证成功，消息未被篡改");
            return jsonMessage.toJSONString();
        }
//-----------------------------------------------------------------------
        //加密发送消息 车端公钥、Tsp私钥
        //获取车端公钥
//        String carVIN = bindInfoDao.findCarVINByUserPhone(userPhone);
//        String carPublicKey = carCertDao.findCarPublicKey(carVIN);
//        byte[] bCode = DHCoder.encrypt(aDecode, carPublicKey, tspPrivateKey);
        return "发送错误";
    }
}
