package edu.hebeu.po;

public class UserCert {
    private int userCertId;
    private String userCertPath;
    private String userCertUpdateTime;
    private int userCertState;
    private String userPublicKey;

    public UserCert(int userCertId, String userCertPath, String userCertUpdateTime, int userCertState, String userPublicKey) {
        this.userCertId = userCertId;
        this.userCertPath = userCertPath;
        this.userCertUpdateTime = userCertUpdateTime;
        this.userCertState = userCertState;
        this.userPublicKey = userPublicKey;
    }

    public UserCert() {
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
