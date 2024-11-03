package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    // Method to check for existing chat between user1 and user2
    Optional<Chat> findByUser1IdAndUser2Id(Long user1Id, Long user2Id);
    
    // Method to check for existing chat between user2 and user1
    Optional<Chat> findByUser1IdAndUser2IdOrUser1IdAndUser2Id(Long firstUserId, Long secondUserId, Long secondUserIdForReverseCheck, Long firstUserIdForReverseCheck);
    
    @Query("SELECT c FROM Chat c WHERE c.user1Id = :userId OR c.user2Id = :userId")
    List<Chat> findChatsByUserId(@Param("userId") Long userId);
}