package com.example.pure.repository;

import com.example.pure.model.Chat;
import com.example.pure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByParticipantsContaining(User user);
}
