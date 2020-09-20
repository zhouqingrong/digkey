package edu.hebeu.util;
//一种通信时的格式类
public class Message {
    private String digitalKey;//数字钥匙
    private int flag;//指令

    public Message(String digitalKey, int flag) {
        this.digitalKey = digitalKey;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Message{" +
                "digitalKey='" + digitalKey + '\'' +
                ", flag=" + flag +
                '}';
    }

    public String getDigitalKey() {
        return digitalKey;
    }

    public void setDigitalKey(String digitalKey) {
        this.digitalKey = digitalKey;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
