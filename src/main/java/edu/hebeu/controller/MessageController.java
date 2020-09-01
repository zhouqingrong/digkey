//package edu.hebeu.controller;
//
//import edu.hebeu.po.User;
//import edu.hebeu.service.MessageService;
//import edu.hebeu.util.Result;
//import edu.hebeu.util.ResultUtil;
//import edu.hebeu.util.ReturnValue;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping("/message")
//public class MessageController {
//    @Autowired
//    private MessageService messageService;
//    //接收并发送消息
//    @RequestMapping(value="/message.do")
//    @ResponseBody
//    public Result receiveMessage(@Param("message") ReturnValue message, @Param("userPhone")String userPhone){
//        try {
//            System.out.println("表现层：接收消息...");
//            System.out.println("接收到的密文"+message);
//            return ResultUtil.success(messageService.receiveMessage(message,userPhone));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultUtil.error(1003,"出现异常");
//        }
//    }
//
////    public Result receiveMessage(@Param("message") byte[] message,@Param("userPhone")String userPhone){
////        try {
////            System.out.println("表现层：接收消息...");
////            System.out.println("接收到的密文"+message);
////            return ResultUtil.success(messageService.receiveMessage(message,userPhone));
////        } catch (Exception e) {
////            e.printStackTrace();
////            return ResultUtil.error(1003,"出现异常");
////        }
////    }
//
//}
