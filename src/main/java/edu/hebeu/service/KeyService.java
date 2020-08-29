package edu.hebeu.service;

import edu.hebeu.po.Key;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface KeyService {
    //新增钥匙
    int addKey(String carVIN) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    //按carVIN查询钥匙
    Key findKey(String userPhone);
}
