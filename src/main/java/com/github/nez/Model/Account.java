package com.github.nez.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Entity
//@Table(name = "account")
public class Account {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid") @GenericGenerator(name = "uuid", strategy = "uuid2") private String id;
    private String username;
    private String password;
    private String email;
    @OneToMany(targetEntity = Account.class)
    private List<Account> friends;
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid") @GenericGenerator(name = "uuid", strategy = "uuid2") private String token;

    public Account(){}

    public Account(String username, String password,String email){
        this.username=username;
        this.password=password;
        this.email=email;
    }

    public Account(String usernameInput,String passwordInput){
        this(usernameInput, passwordInput, null);
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String newUsername){
        username=newUsername;
    }

    public void setPassword(String newPassword){
        password=newPassword;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){ this.token=token;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public ArrayList<Account> getFriends() {
//        return friends;
//    }

//    public ArrayList<Account> addFriend(Account friend){
//        this.getFriends().add(friend);
//        return getFriends();
//    }

}