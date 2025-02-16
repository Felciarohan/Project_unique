package com.dk.chatApp.Controller;

import com.dk.chatApp.Model.chatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class chatController {

    //app/sendMessage
    // End point
    @MessageMapping("/api/sendMessage")
    @SendTo("/topic/messages")
    public chatMessage sendMessage(chatMessage message){
        return message;
    }

    @GetMapping("chat")
    public String chat(){
        return "chat";
    }
}
