package com.dsenvolvendosistemas.chat_app.service;
import com.dsenvolvendosistemas.chat_app.exception.UserException;
import com.dsenvolvendosistemas.chat_app.modal.User;
import com.dsenvolvendosistemas.chat_app.request.UpdateUserRequest;

import java.util.List;

public interface UserService {

    public User findUserProfile(String jwt);

    public User updateUser(Integer userId, UpdateUserRequest req) throws UserException;

    public User findUserById(Integer userId) throws UserException;

    public List<User> searchUser(String query);
}
