package edu.hebeu.util;

import java.util.Base64;
public class UtilHelper {
    //base64字符串转byte[]
    //public static byte[] base64String2ByteFun(String base64Str){
       // return base64Str.getBytes("UTF-8");
    //}
    //byte[]转base64
    public static String byte2Base64StringFun(byte[] b){
        return  Base64.getEncoder().encodeToString(b);
    }
}



