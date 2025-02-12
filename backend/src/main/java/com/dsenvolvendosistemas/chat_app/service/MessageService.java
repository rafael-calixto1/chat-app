package com.dsenvolvendosistemas.chat_app.service;


import java.util.List;

import com.dsenvolvendosistemas.chat_app.exception.ChatException;
import com.dsenvolvendosistemas.chat_app.exception.MessageException;
import com.dsenvolvendosistemas.chat_app.exception.UserException;
import com.dsenvolvendosistemas.chat_app.modal.Message;
import com.dsenvolvendosistemas.chat_app.request.SendMessageRequest;

public interface MessageService  {

    public Message sendMessage(SendMessageRequest req) throws UserException, ChatException;

    public List<Message> getChatsMessages(Integer chatId) throws ChatException;

    public Message findMessageById(Integer messageId) throws MessageException;

    public String deleteMessage(Integer messageId) throws MessageException;

}
