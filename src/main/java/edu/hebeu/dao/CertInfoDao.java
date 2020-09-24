package edu.hebeu.dao;

import edu.hebeu.po.CertInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface CertInfoDao {
    //    添加用户
    @Insert("insert into certinfo(cert_name,phone) values(#{certinfo.cert_name},#{certinfo.phone})")
    int addCertInfo(@Param("certinfo") CertInfo certInfo);
}
