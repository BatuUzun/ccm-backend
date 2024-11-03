package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Chat;
import com.example.demo.entity.ChatDTO;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.UserProfileRepository;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;
    
    @Autowired
    private UserProfileRepository userProfileRepository; // Repository for user profile data


    public Chat createChat(Chat chat) {
        // Check if a chat already exists between user1 and user2 or user2 and user1
        boolean chatExists = chatRepository.findByUser1IdAndUser2IdOrUser1IdAndUser2Id(
            chat.getUser1Id(), chat.getUser2Id(), chat.getUser2Id(), chat.getUser1Id()).isPresent();

        if (chatExists) {
            // Throw an exception if chat already exists
            throw new IllegalArgumentException("Chat already exists between the users");
        }

        // Save the new chat if it doesn't exist
        return chatRepository.save(chat);
    }
    
    public List<ChatDTO> getChatsByUserId(Long userId) {
        List<Chat> chats = chatRepository.findChatsByUserId(userId); // Fetch chats for the user
        List<ChatDTO> chatDTOs = new ArrayList<>();

        for (Chat chat : chats) {
            // Fetch user profiles for both users in the chat
            String user1ProfilePicture = userProfileRepository.findProfilePictureByUserId(chat.getUser1Id());
            String user2ProfilePicture = userProfileRepository.findProfilePictureByUserId(chat.getUser2Id());

            String user1Username = userProfileRepository.findUsernameByUserId(chat.getUser1Id());
            String user2Username = userProfileRepository.findUsernameByUserId(chat.getUser2Id());

            // Create a ChatDTO and set the values
            ChatDTO chatDTO = new ChatDTO();
            chatDTO.setId(chat.getId());
            chatDTO.setUser1Id(chat.getUser1Id());
            chatDTO.setUser2Id(chat.getUser2Id());

            if (userId.equals(chat.getUser1Id())) {
                chatDTO.setUser1ProfilePicture(user1ProfilePicture);
                chatDTO.setUser1Username(user1Username);
                chatDTO.setUser2ProfilePicture(user2ProfilePicture);
                chatDTO.setUser2Username(user2Username);
            } else {
                chatDTO.setUser1ProfilePicture(user2ProfilePicture);
                chatDTO.setUser1Username(user2Username);
                chatDTO.setUser2ProfilePicture(user1ProfilePicture);
                chatDTO.setUser2Username(user1Username);
            }

            chatDTOs.add(chatDTO);
        }
        return chatDTOs;
    }


}