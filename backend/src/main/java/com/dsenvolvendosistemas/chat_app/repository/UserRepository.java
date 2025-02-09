package com.dsenvolvendosistemas.chat_app.repository;

import java.util.List;
import java.util.Optional;

import com.dsenvolvendosistemas.chat_app.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.full_name LIKE %:name%")
    List<User> searchUsers(@Param("name") String name);


}
