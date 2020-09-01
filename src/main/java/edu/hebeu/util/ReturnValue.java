package edu.hebeu.util;

import java.security.Key;

public class ReturnValue {
    public ReturnValue(Key k, byte[] b) {
        key = k;
        bytes = b;
    }
    private Key key;
    byte[]  bytes;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
