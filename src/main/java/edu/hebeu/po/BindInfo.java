package edu.hebeu.po;

public class BindInfo {
    private String userPhone;
    private String carVIN;

    @Override
    public String toString() {
        return "BindInfo{" +
                "userPhone='" + userPhone + '\'' +
                ", carVIN='" + carVIN + '\'' +
                '}';
    }

    public BindInfo(String userPhone, String carVIN) {
        this.userPhone = userPhone;
        this.carVIN = carVIN;
    }

    public BindInfo() {
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCarVIN() {
        return carVIN;
    }

    public void setCarVIN(String carVIN) {
        this.carVIN = carVIN;
    }
}
