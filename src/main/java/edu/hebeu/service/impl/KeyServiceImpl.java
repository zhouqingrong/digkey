package edu.hebeu.service.impl;

import edu.hebeu.dao.BindInfoDao;
import edu.hebeu.dao.KeyDao;
import edu.hebeu.po.Key;
import edu.hebeu.service.KeyService;
import edu.hebeu.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


@Service
public class KeyServiceImpl implements KeyService {
    @Autowired
    private KeyDao keyDao;
    @Autowired
    private BindInfoDao bindInfoDao;
    //生成钥匙
    @Override
    public int addKey(String carVIN) {
//        //加密生成数字钥匙
//        byte[] bytes = MD5.computeMD5(carVIN);
//        //Base64 Encoded
//        String encoded = Base64.getEncoder().encodeToString(bytes);
//        //Base64 Decoded
//        byte[] decoded = Base64.getDecoder().decode(encoded);
//        //Verify original content
//        String keyNumber = new String(decoded);
//        System.out.println(keyNumber);
        String keyNumber="";
        try {
            keyNumber = MD5.EncoderByMd5(carVIN);
            System.out.println(keyNumber);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Key key = new Key(keyNumber,carVIN,1);
        return keyDao.addKey(key);
    }
    //查询数字钥匙
    @Override
    public Key findKey(String userPhone) {
        String carVIN = bindInfoDao.findCarVINByUserPhone(userPhone);
        return keyDao.findKeyByCarVIN(carVIN);
    }
}
