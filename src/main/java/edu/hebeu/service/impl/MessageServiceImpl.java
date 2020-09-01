package edu.hebeu.service.impl;

import edu.hebeu.dao.BindInfoDao;
import edu.hebeu.dao.CarCertDao;
import edu.hebeu.dao.SecretKeyDao;
import edu.hebeu.dao.UserCertDao;
import edu.hebeu.service.MessageService;
import edu.hebeu.util.DHCoder;
import edu.hebeu.util.RSAUtil;
import edu.hebeu.util.ReturnValue;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;

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
    public ReturnValue receiveMessage(ReturnValue message, String userPhone) throws Exception {
        //获取tsp私钥
        String tspPrivateKey = secretKeyDao.findPrivateKey();
        //获取app端用户公钥
        String userPublicKey = userCertDao.findUserPublicKey(userPhone);
        //打开包
       Key _3DESKey = message.getKey();
       byte[] secretMsg = message.getBytes();
        //云端私钥解密，拿到对称密钥

        //使用对称密钥解密 加密信息，拿到明文消息、数字签名

        //对数字签名：使用app公钥解密，拿到摘要
        RSAUtil.verify();
        //对明文消息：使用hash算法，拿到摘要
        //对比摘要成功后，获得明文指令-----》转到加密发送

        byte[] aDecode = DHCoder.decrypt(acode, userPublicKey, tspPrivateKey);
        //获得明文
        String aOutput = (new String(aDecode));
        System.out.println("转换后明文："+aOutput);
//-----------------------------------------------------------------------
        //加密发送消息 车端公钥、Tsp私钥
        //获取车端公钥
        String carVIN = bindInfoDao.findCarVINByUserPhone(userPhone);
        String carPublicKey = carCertDao.findCarPublicKey(carVIN);
        byte[] bCode = DHCoder.encrypt(aDecode, carPublicKey, tspPrivateKey);
        return bCode;
    }
//    public byte[] receiveMessage(byte[] acode, String userPhone) throws Exception {
//        //获取密文数组
////        byte[] acode = message.getBytes();
//        //获取tsp私钥
//        String tspPrivateKey = secretKeyDao.findPrivateKey();
//       //获取app端用户公钥
//        String userPublicKey = userCertDao.findUserPublicKey(userPhone);
//        // 由app公钥，tsp私钥解密
//        byte[] aDecode = DHCoder.decrypt(acode, userPublicKey, tspPrivateKey);
//        //获得明文
//        String aOutput = (new String(aDecode));
//        System.out.println("转换后明文："+aOutput);
////-----------------------------------------------------------------------
//        //加密发送消息 车端公钥、Tsp私钥
//        //获取车端公钥
//        String carVIN = bindInfoDao.findCarVINByUserPhone(userPhone);
//        String carPublicKey = carCertDao.findCarPublicKey(carVIN);
//        byte[] bCode = DHCoder.encrypt(aDecode, carPublicKey, tspPrivateKey);
//        return bCode;
//    }


}
