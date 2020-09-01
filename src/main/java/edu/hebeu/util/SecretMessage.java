package edu.hebeu.util;

import edu.hebeu.util.Message;

import java.util.Arrays;

public class SecretMessage {
    private Message message;
    private byte[] sign;
    public SecretMessage(Message m, byte[] s) {
        message = m;//消息（明文指令、数字钥匙）
        sign = s;//数字签名
    }

    @Override
    public String toString() {
        return "SecretMessage{" +
                "message=" + message +
                ", sign=" + Arrays.toString(sign) +
                '}';
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public byte[] getSign() {
        return sign;
    }

    public void setSign(byte[] sign) {
        this.sign = sign;
    }
}
