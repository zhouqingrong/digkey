package edu.hebeu.po;

public class CarCert {
    private int carCertId;
    private String carCertPath;
    private String carCertUpdateTime;
    private int carCertState;
    private String carPublicKey;
    private String carVIN;

    @Override
    public String toString() {
        return "CarCert{" +
                "carCertId=" + carCertId +
                ", carCertPath='" + carCertPath + '\'' +
                ", carCertUpdateTime='" + carCertUpdateTime + '\'' +
                ", carCertState=" + carCertState +
                ", carPublicKey='" + carPublicKey + '\'' +
                ", carVIN='" + carVIN + '\'' +
                '}';
    }

    public CarCert() {
    }

    public CarCert(String carCertPath, String carCertUpdateTime, int carCertState, String carPublicKey, String carVIN) {
        this.carCertPath = carCertPath;
        this.carCertUpdateTime = carCertUpdateTime;
        this.carCertState = carCertState;
        this.carPublicKey = carPublicKey;
        this.carVIN = carVIN;
    }

    public String getCarCertPath() {
        return carCertPath;
    }

    public void setCarCertPath(String carCertPath) {
        this.carCertPath = carCertPath;
    }

    public String getCarCertUpdateTime() {
        return carCertUpdateTime;
    }

    public void setCarCertUpdateTime(String carCertUpdateTime) {
        this.carCertUpdateTime = carCertUpdateTime;
    }

    public int getCarCertState() {
        return carCertState;
    }

    public void setCarCertState(int carCertState) {
        this.carCertState = carCertState;
    }

    public String getCarPublicKey() {
        return carPublicKey;
    }

    public void setCarPublicKey(String carPublicKey) {
        this.carPublicKey = carPublicKey;
    }

    public String getCarVIN() {
        return carVIN;
    }

    public void setCarVIN(String carVIN) {
        this.carVIN = carVIN;
    }
}
