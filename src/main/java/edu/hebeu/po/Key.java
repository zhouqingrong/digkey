package edu.hebeu.po;

public class Key {
    private int keyId;
    private String keyNumber;
    private String carVIN;
    private int keyState;

    @Override
    public String toString() {
        return "Key{" +
                "keyNumber='" + keyNumber + '\'' +
                ", carVIN='" + carVIN + '\'' +
                ", keyState=" + keyState +
                '}';
    }

    public Key(String keyNumber, String carVIN, int keyState) {
        this.keyNumber = keyNumber;
        this.carVIN = carVIN;
        this.keyState = keyState;
    }

    public Key() {
    }

    public String getKeyNumber() {
        return keyNumber;
    }

    public void setKeyNumber(String keyNumber) {
        this.keyNumber = keyNumber;
    }

    public String getCarVIN() {
        return carVIN;
    }

    public void setCarVIN(String carVIN) {
        this.carVIN = carVIN;
    }

    public int getKeyState() {
        return keyState;
    }

    public void setKeyState(int keyState) {
        this.keyState = keyState;
    }
}
