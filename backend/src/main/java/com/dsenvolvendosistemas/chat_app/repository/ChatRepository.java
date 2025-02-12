package com.dsenvolvendosistemas.chat_app.repository;

import com.dsenvolvendosistemas.chat_app.modal.Chat;
import com.dsenvolvendosistemas.chat_app.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

    @Query("select c from Chat c join c.users u where u.id=:userId")
    public List<Chat> findChatByUserId(Integer userId);

    @Query("select c from Chat c Where c.is_group=false And :user Member of c.users And :reqUser Member of c.users")
    public Chat findSingleChatByUsersId(@Param("user")User user, @Param("reqUser") User reqUser);
}
