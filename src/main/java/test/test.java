package test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class test {
    @Test
    public void test(){
        String miwenIn ="oHm4NZxnPbt81ESR1Jy1WzPukuXO+UV9/N7PCQia2XfV2ilku6CbbILOCsMwYa6TTwfX+2Fg1QquQGeSgk3yIBAhLpefIDIY+8mJttt4q9QSE2d7vkqmbGigYLfdwf4Rwfo4YorPhMCXGZI2UyXmeWLSmt5jurZzHeUj/GGkMaBNNeJTGt7worcwDdWzjN2gxTzNRbNeph1VxxQPMYGWWddlNP05YGgpMORtgAMsMMKEEpfeoHYU8tqc1EFhWrY4fNUW48+yOblIxqvGC9fRgksWqAoTU9BFGm5VLhdRTX3D/2xqPjOJGaPuqzLCPAvH";
        String output1;
        String miyaoIn = "WpiebWj037NWo6gtLng1zrvF5mgikEECEPyvrD/kLwk30EADeyY8Nl9wURYZx8z08BtSierQM/o/lQebduFMlC0t+lF5EltPPlrNQqMHQqBVRd6l3CGsQyA8ojrwRMmNqJmcs72q6VK1beGOrBNkDS4gChrwBFFI/AYe4/qKCZw=";
        String output2;
            try {
                output1 = new String(miwenIn.getBytes("UTF-8"), "ISO-8859-1");
                System.out.println("转换前密文："+miwenIn);
                System.out.println("转换后密文："+output1);
                output2 = new String(miyaoIn.getBytes("UTF-8"), "ISO-8859-1");
                System.out.println("转换前密钥："+miyaoIn);
                System.out.println("转换后密钥："+output2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
    }
}
