package edu.hebeu.po;

public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userPhone;
    private int userType;
    private String userCreateDate;
    private String userNumber;
    private int userState;
    private String userPublicKey;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userType=" + userType +
                ", userCreateDate='" + userCreateDate + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", userState=" + userState +
                ", userPublicKey='" + userPublicKey + '\'' +
                '}';
    }

    public User() {
    }

    public User(int userId, String userName, String userPwd, String userPhone, int userType, String userCreateDate, String userNumber, int userState, String userPublicKey) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userType = userType;
        this.userCreateDate = userCreateDate;
        this.userNumber = userNumber;
        this.userState = userState;
        this.userPublicKey = userPublicKey;
    }

    public String getUserPublicKey() {
        return userPublicKey;
    }

    public void setUserPublicKey(String userPublicKey) {
        this.userPublicKey = userPublicKey;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
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
