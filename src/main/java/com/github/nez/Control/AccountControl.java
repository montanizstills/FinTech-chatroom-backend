package com.github.nez.Control;

import com.github.nez.Model.Account;
import com.github.nez.Model.AccountBuilder;
import com.github.nez.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller @RequestMapping(value="/account")
@CrossOrigin("http://localhost:4200")
public class AccountControl {
    private AccountService accountService;

    @Autowired
    public AccountControl(AccountService accountService){
        this.accountService=accountService;
    }

    @RequestMapping(value="/create-account", method= RequestMethod.POST)
    public ResponseEntity create(@RequestBody Account account){
         account = new AccountBuilder().setUsername(account.getUsername()).setPassword(account.getPassword()).setEmail(account.getEmail()).createAccount();
        account=accountService.createAccount(account);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(account, HttpStatus.CREATED);
        System.out.println("Account: "+ account +" has been created!");
        return responseEntity;
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody String username, String password){
       Account account = new AccountBuilder().setUsername(username).setPassword(password).createAccount();
        ResponseEntity<?> responseEntity = new ResponseEntity<>(accountService.login(account), HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value="find-account", method=RequestMethod.GET)
    public ResponseEntity find(@RequestBody Account account){
        accountService.find(account.getId());
        ResponseEntity responseEntity = new ResponseEntity<>(account,HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/add-friend", method=RequestMethod.PUT)
    public ResponseEntity addFriend(@RequestBody String friendId, String myId){
        String ourId = friendId+","+myId;
        accountService.addFriend(ourId);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(friendId,HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @RequestMapping(value="get-friends-list", method=RequestMethod.GET)
    public ResponseEntity getFriends(@PathVariable String id){
        Account account = new AccountBuilder().setId(id).createAccount();
        ArrayList friends = accountService.getFriends(account);
        ResponseEntity responseEntity = new ResponseEntity(friends, HttpStatus.OK);
        return responseEntity;
    }

}
