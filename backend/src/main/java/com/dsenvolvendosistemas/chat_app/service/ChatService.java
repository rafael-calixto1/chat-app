package com.dsenvolvendosistemas.chat_app.service;

import com.dsenvolvendosistemas.chat_app.exception.ChatException;
import com.dsenvolvendosistemas.chat_app.exception.UserException;
import com.dsenvolvendosistemas.chat_app.modal.Chat;
import com.dsenvolvendosistemas.chat_app.request.GroupChatRequest;

import java.util.List;

public interface ChatService {

    public Chat createChat(Integer reqUserId, Integer userId2, boolean isGroup) throws UserException;

    public Chat findChatById(Integer chatId) throws ChatException;

    public List<Chat> findAllChatByUserId(Integer userId) throws UserException;

    public Chat createGroup(GroupChatRequest req, Integer reqUerId) throws UserException;

    public Chat addUserToGroup(Integer userId, Integer chatId) throws UserException, ChatException;

    public Chat renameGroup(Integer chatId,String groupName, Integer reqUserId) throws ChatException, UserException;

    public Chat removeFromGroup(Integer chatId,Integer userId, Integer reqUser) throws UserException,ChatException;

    public Chat deleteChat(Integer chatId, Integer userId) throws ChatException, UserException;

}
