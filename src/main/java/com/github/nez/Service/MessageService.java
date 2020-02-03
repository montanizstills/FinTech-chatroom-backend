package com.github.nez.Service;

import com.github.nez.DataRetriever;
import com.github.nez.Model.Message;
import com.github.nez.Respository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    public Message sendMessage(Message incomingMessage) {
        String response="";
        response+= new DataRetriever().decipherMessage(incomingMessage.getMessage());
        Message outgoingMessage = new Message("",response);
        messageRepository.save(outgoingMessage);
        return outgoingMessage;
    }

 }

