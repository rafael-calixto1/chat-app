package com.dsenvolvendosistemas.chat_app.controller;

import com.dsenvolvendosistemas.chat_app.exception.ChatException;
import com.dsenvolvendosistemas.chat_app.exception.UserException;
import com.dsenvolvendosistemas.chat_app.modal.Chat;
import com.dsenvolvendosistemas.chat_app.modal.Message;
import com.dsenvolvendosistemas.chat_app.modal.User;
import com.dsenvolvendosistemas.chat_app.request.SendMessageRequest;
import com.dsenvolvendosistemas.chat_app.service.ChatService;
import com.dsenvolvendosistemas.chat_app.service.MessageService;
import com.dsenvolvendosistemas.chat_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
public class RealTimeChat {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/message")
    @SendTo("/group/public")
    public Message receiveMessage(@Payload Message message){

        System.out.println("receive message in public ---------- ");

//    	simpMessagingTemplate.convertAndSend("/group/" +req.getChatId().toString(), req);

        simpMessagingTemplate.convertAndSend("/group/"+message.getChat().getId().toString(), message);

        return message;
    }

    @MessageMapping("/chat/{groupId}")
    public Message sendToUser(@Payload SendMessageRequest req, @Header("Authorization") String jwt, @DestinationVariable String groupId) throws UserException, ChatException {
        System.out.println("recived private message - - - - - "+req);
        User user=userService.findUserProfile(jwt);
        System.out.println("userr private message - - - - - - "+user);
        req.setUserId(user.getId());

        Chat chat=chatService.findChatById(req.getChatId());

        Message createdMessage = messageService.sendMessage(req);

        User reciverUser=reciver(chat, user);

        simpMessagingTemplate.convertAndSendToUser(groupId, "/private", createdMessage);

        return createdMessage;
    }

    public User reciver(Chat chat,User reqUser) {
        Iterator<User> iterator = chat.getUsers().iterator();

        User user1 = iterator.next(); // get the first user
        User user2 = iterator.next();

        if(user1.getId().equals(reqUser.getId())){
            return user2;
        }
        return user1;
    }
}
