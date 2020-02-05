package com.github.nez.Service;

import com.github.nez.Respository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService implements MessageServiceInterface {
    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageRepository getRepository() {
        return messageRepository;
    }
}

