package edu.hebeu.service;

import edu.hebeu.po.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface UserService {
    //添加用户
    int addUser(User user);
    //更新用户状态
    int updateUserState(int userState,String userPhone);
    //查询用户状态
    int findUserState(String userPhone);
    //查询全部用户
    public List<User> findAllUsers();

    //按用户电话号码查询
    public User findUserByPhone(String userPhone);

    //按用户名模糊查询
    List<User> findUsersByName(String userName);

    //按用户id查询到用户
    User findUserById(int userId);

    //按身份证号查询用户
    User findUserByUserNumber(String userNumber);
}
