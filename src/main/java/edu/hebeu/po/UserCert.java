package edu.hebeu.po;

import org.springframework.beans.factory.annotation.Autowired;

public class UserCert {
    private int userCertId;
    private String userCertPath;
    private String userCertUpdateTime;
    private int userCertState;
    private String userPublicKey;
    private String userPhone;

    @Override
    public String toString() {
        return "UserCert{" +
                "userCertId=" + userCertId +
                ", userCertPath='" + userCertPath + '\'' +
                ", userCertUpdateTime='" + userCertUpdateTime + '\'' +
                ", userCertState=" + userCertState +
                ", userPublicKey='" + userPublicKey + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }

    public UserCert(String userCertPath, String userCertUpdateTime, int userCertState, String userPublicKey, String userPhone) {
        this.userCertPath = userCertPath;
        this.userCertUpdateTime = userCertUpdateTime;
        this.userCertState = userCertState;
        this.userPublicKey = userPublicKey;
        this.userPhone = userPhone;
    }

    public UserCert() {
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserCertId() {
        return userCertId;
    }

    public void setUserCertId(int userCertId) {
        this.userCertId = userCertId;
    }

    public String getUserCertPath() {
        return userCertPath;
    }

    public void setUserCertPath(String userCertPath) {
        this.userCertPath = userCertPath;
    }

    public String getUserCertUpdateTime() {
        return userCertUpdateTime;
    }

    public void setUserCertUpdateTime(String userCertUpdateTime) {
        this.userCertUpdateTime = userCertUpdateTime;
    }

    public int getUserCertState() {
        return userCertState;
    }

    public void setUserCertState(int userCertState) {
        this.userCertState = userCertState;
    }

    public String getUserPublicKey() {
        return userPublicKey;
    }

    public void setUserPublicKey(String userPublicKey) {
        this.userPublicKey = userPublicKey;
    }
}
