package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Message;
import com.example.demo.entity.MessageRequest;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(MessageRequest request) {
        Message message = new Message();
        message.setChatId(request.getChatId());
        message.setSenderId(request.getSenderId());
        message.setMessage(request.getMessage());
        message.setTime(LocalDateTime.now()); // Set current timestamp

        return messageRepository.save(message);
    }
    
    public List<Message> getChatLog(Long chatId) {
        return messageRepository.findByChatIdOrderByTimeAsc(chatId);
    }
}
