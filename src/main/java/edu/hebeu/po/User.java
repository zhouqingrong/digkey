package edu.hebeu.po;

public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userNickName;
    private String userPhone;
    private int userType;
    private String userCreateDate;
    private String userNumber;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userType=" + userType +
                ", userCreateDate='" + userCreateDate + '\'' +
                ", userNumber='" + userNumber + '\'' +
                '}';
    }

    public User(int userId, String userName, String userPwd, String userNickName, String userPhone, int userType, String userCreateDate, String userNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userNickName = userNickName;
        this.userPhone = userPhone;
        this.userType = userType;
        this.userCreateDate = userCreateDate;
        this.userNumber = userNumber;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(String userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
