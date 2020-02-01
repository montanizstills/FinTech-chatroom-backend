package com.github.nez.Control;

import com.github.nez.Model.Message;
import com.github.nez.Service.MessageService;
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

    private MessageService messageService;

    @Autowired
    public MessageControl(MessageService messageService){
        this.messageService =messageService;
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity sendMessage(@RequestBody Message message){
        Message decipheredMessage = messageService.sendMessage(message);
        System.out.println("The deciphered message is: "+decipheredMessage);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(decipheredMessage, HttpStatus.OK);
        return responseEntity;
    }

}
