package edu.hebeu.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface BindInfoService {
    //新增绑定信息
    int addBindInfo(String userPhone,String carVIN);
}
