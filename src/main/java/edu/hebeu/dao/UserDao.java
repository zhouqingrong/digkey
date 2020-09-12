package edu.hebeu.dao;

import edu.hebeu.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
//    添加用户
    @Insert("insert into user(userName,userPwd,userPhone,userType,userCreateDate,userNumber,userState) values(#{user.userName},#{user.userPwd},#{user.userPhone},#{user.userType},now(),#{user.userNumber},1)")
    int addUser(@Param("user")User user);
    //修改用户状态
    @Update("update user set userState = #{userState} where userPhone = #{userPhone} ")
    int updateUserState(@Param("userState") int userState,@Param("userPhone") String userPhone);
    //按userPhone查询用户登录状态
    @Select("select userState from user where userPhone = #{userPhone}")
    int findUserState(@Param("userPhone")String userPhone);

    //    查询全部用户
    @Select(value="select * from user")
    public List<User> findAllUsers();

    //按用户电话号码查询
    @Select("select * from user where 1=1 and userPhone = #{userPhone}")
    public User findUserByPhone(@Param("userPhone") String userPhone);

    //按用户名模糊查询
    @Select("select * from user where userName like CONCAT('%',#{userName},'%') ")
    List<User> findUsersByName(@Param("userName")String userName);

    //按用户id查询到用户
    @Select("select * from user where 1 =1 and userId = #{userId}")
    User findUserById(@Param("userId") int userId);

    //按身份证号查询用户
    @Select ("select * from user where 1=1 and userNumber=#{userNumber}")
    User findUserByUserNumber(@Param("userNumber") String userNumber);
}
