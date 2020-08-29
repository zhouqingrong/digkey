package edu.hebeu.po;

public class Car {
    private  int carId;
    private String carVIN;
    private String carType;
    private String carColor;
    private String carCreateDate;

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carVIN='" + carVIN + '\'' +
                ", carType='" + carType + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carCreateDate='" + carCreateDate + '\'' +
                '}';
    }

    public Car(int carId, String carVIN, String carType, String carColor, String carCreateDate) {
        this.carId = carId;
        this.carVIN = carVIN;
        this.carType = carType;
        this.carColor = carColor;
        this.carCreateDate = carCreateDate;
    }

    public Car() {
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarVIN() {
        return carVIN;
    }

    public void setCarVIN(String carVIN) {
        this.carVIN = carVIN;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarCreateDate() {
        return carCreateDate;
    }

    public void setCarCreateDate(String carCreateDate) {
        this.carCreateDate = carCreateDate;
    }
}
