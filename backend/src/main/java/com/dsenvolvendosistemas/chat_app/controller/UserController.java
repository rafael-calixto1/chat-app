package com.dsenvolvendosistemas.chat_app.controller;

import com.dsenvolvendosistemas.chat_app.controller.mapper.UserDtoMapper;
import com.dsenvolvendosistemas.chat_app.dto.UserDto;
import com.dsenvolvendosistemas.chat_app.exception.UserException;
import com.dsenvolvendosistemas.chat_app.modal.User;
import com.dsenvolvendosistemas.chat_app.request.UpdateUserRequest;
import com.dsenvolvendosistemas.chat_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUserHandler(@RequestBody UpdateUserRequest req, @PathVariable Integer userId) throws UserException {
        System.out.println("updated user -------- ");
        User updatedUser=userService.updateUser(userId, req);
        UserDto userDto= UserDtoMapper.toUserDTO(updatedUser);

        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserProfileHandler(@RequestHeader("Authorization")String jwt){
        System.out.println("req profile ----- ");

        User user=userService.findUserProfile(jwt);

        UserDto userDto=UserDtoMapper.toUserDTO(user);

        System.out.println("req profile "+userDto.getEmail());

        return new ResponseEntity<UserDto>(userDto,HttpStatus.ACCEPTED);
    }

    @GetMapping("/search")
    public ResponseEntity<HashSet<UserDto>> searchUsersByName(@RequestParam("name") String name) {

        System.out.println("search user ------- ");

        List<User> users=userService.searchUser(name);

        HashSet<User> set=new HashSet<>(users);

        HashSet<UserDto> userDtos=UserDtoMapper.toUserDtos(set);

        System.out.println("search result ------ "+userDtos);

        return new ResponseEntity<>(userDtos,HttpStatus.ACCEPTED);
    }

}
