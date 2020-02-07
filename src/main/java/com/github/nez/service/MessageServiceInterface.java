package com.github.nez.service;

import com.github.nez.DataRetriever;
import com.github.nez.model.Message;
import com.github.nez.repository.MessageRepository;

public interface MessageServiceInterface {

    default Message sendMessage(Message incomingMessage) {
        String response = "";
        System.out.println(incomingMessage.getMessage());
        response = new DataRetriever().decipherMessage(incomingMessage.getMessage());
        return new Message("", response);
    }

    default Message deleteMessage(String id) {
        Message deletedMessage = getRepository().findById(id).get();
        getRepository().delete(deletedMessage);
        return deletedMessage;
    }

    MessageRepository getRepository();
}
