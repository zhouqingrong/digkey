package edu.hebeu.service;

import edu.hebeu.util.ReturnValue;

public interface MessageService {
    //接收消息
    public String receiveMessage(String message,String secretKey, String UserPhone) throws Exception;
    //发送消息
//    public String sendMessage(String message,String );
}
