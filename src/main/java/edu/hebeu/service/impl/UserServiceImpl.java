package edu.hebeu.service.impl;

import edu.hebeu.dao.UserDao;
import edu.hebeu.po.User;
import edu.hebeu.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
// 添加用户
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }
//更新用户状态
    @Override
    public int updateUserState(int userState, String userPhone) {
        return userDao.updateUserState(userState,userPhone);
    }
    //查询用户状态
    @Override
    public int findUserState(String userPhone) {
        return userDao.findUserState(userPhone);
    }
    // 查询全部用户
    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
//按电话号码查询用户
    @Override
    public User findUserByPhone(String userPhone) {
        return userDao.findUserByPhone(userPhone);
    }
//按名字模糊查询用户
    @Override
    public List<User> findUsersByName(String userName) {
        return userDao.findUsersByName(userName);
    }
//按用户Id查询
    @Override
    public User findUserById(int userId) {
        return userDao.findUserById(userId);
    }
//按身份证号查询用户
    @Override
    public User findUserByUserNumber(String userNumber) {
        return userDao.findUserByUserNumber(userNumber);
    }
}
