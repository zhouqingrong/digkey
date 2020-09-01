package edu.hebeu.service;

import edu.hebeu.util.ReturnValue;

public interface MessageService {
    //接收消息
    public ReturnValue receiveMessage(ReturnValue message, String UserPhone) throws Exception;
//    public byte[] receiveMessage(byte[] message,String UserPhone) throws Exception;
    //发送消息
//    public String sendMessage(String message,String );
}
