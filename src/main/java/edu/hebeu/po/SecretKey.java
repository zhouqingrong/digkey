package edu.hebeu.po;

public class SecretKey {
    private int tspSecretKeyId;
    private String tspPublicKey;
    private String tspPrivateKey;
    private int tspSecretKeyState;

    @Override
    public String toString() {
        return "SecretKey{" +
                "tspSecretKeyId=" + tspSecretKeyId +
                ", tspPublicKey='" + tspPublicKey + '\'' +
                ", tspPrivateKey='" + tspPrivateKey + '\'' +
                ", tspSecretKeyState=" + tspSecretKeyState +
                '}';
    }

    public SecretKey(String tspPublicKey, String tspPrivateKey, int tspSecretKeyState) {
        this.tspPublicKey = tspPublicKey;
        this.tspPrivateKey = tspPrivateKey;
        this.tspSecretKeyState = tspSecretKeyState;
    }

    public SecretKey() {
    }

    public int getTspSecretKeyId() {
        return tspSecretKeyId;
    }

    public void setTspSecretKeyId(int tspSecretKeyId) {
        this.tspSecretKeyId = tspSecretKeyId;
    }

    public String getTspPublicKey() {
        return tspPublicKey;
    }

    public void setTspPublicKey(String tspPublicKey) {
        this.tspPublicKey = tspPublicKey;
    }

    public String getTspPrivateKey() {
        return tspPrivateKey;
    }

    public void setTspPrivateKey(String tspPrivateKey) {
        this.tspPrivateKey = tspPrivateKey;
    }

    public int getTspSecretKeyState() {
        return tspSecretKeyState;
    }

    public void setTspSecretKeyState(int tspSecretKeyState) {
        this.tspSecretKeyState = tspSecretKeyState;
    }
}
