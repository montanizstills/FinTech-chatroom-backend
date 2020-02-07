package com.github.nez.model;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Message {

   @javax.persistence.Id
   @Id@GeneratedValue(strategy = GenerationType.AUTO) private Long id;
   private String message;

    public Message(){
    }

    public Message(String Id,String message){
        this.id=id;
        this.message=message;
    }

//    @ManyToOne(targetEntity = Account.class)
//    private Array messagesList;

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String newMessage){
        this.message=newMessage;
    }

    public Long getMessageId() {
        return id;
    }
}
