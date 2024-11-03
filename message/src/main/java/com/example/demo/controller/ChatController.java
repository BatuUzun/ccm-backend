package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Chat;
import com.example.demo.entity.ChatDTO;
import com.example.demo.entity.Message;
import com.example.demo.entity.MessageRequest;
import com.example.demo.service.ChatService;
import com.example.demo.service.MessageService;

@RestController
@RequestMapping("/message")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/create-chat")
    public ResponseEntity<?> createChat(@RequestBody Chat chat) {
        try {
            Chat createdChat = chatService.createChat(chat);
            return new ResponseEntity<>(createdChat, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChatDTO>> getChatsByUserId(@PathVariable Long userId) {
        List<ChatDTO> chats = chatService.getChatsByUserId(userId);
        return ResponseEntity.ok(chats);
    }
    
    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody MessageRequest request) {
        return messageService.sendMessage(request);
    }
    
    @GetMapping("/chat/{chatId}")
    public List<Message> getChatLog(@PathVariable Long chatId) {
        return messageService.getChatLog(chatId);
    }

}