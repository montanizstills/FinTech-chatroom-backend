package com.github.nez.control;

import com.github.nez.model.Message;
import com.github.nez.service.MessageService;
import com.github.nez.service.MessageServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller @RequestMapping(value="/messaging")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageControl {

    private MessageServiceInterface messageServiceInterface;

    @Autowired
    public MessageControl(MessageService messageService){
        this.messageServiceInterface = messageService;
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity sendMessage(@RequestBody Message message){
        Message decipheredMessage = messageServiceInterface.sendMessage(message);
        System.out.println("The deciphered message is: "+decipheredMessage);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(decipheredMessage, HttpStatus.OK);
        return responseEntity;
    }

}
