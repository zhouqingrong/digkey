package edu.hebeu.util;

public class Message {
    private String digitalKey;//数字钥匙
    private String flag;//指令

    @Override
    public String toString() {
        return "Message{" +
                "digitalKey='" + digitalKey + '\'' +
                ", flag=" + flag +
                '}';
    }

    public Message(String digitalKey, String flag) {
        this.digitalKey = digitalKey;
        this.flag = flag;
    }

    public String getDigitalKey() {
        return digitalKey;
    }

    public void setDigitalKey(String digitalKey) {
        this.digitalKey = digitalKey;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
