package com.github.nez.Service;

import com.github.nez.Model.Account;
import com.github.nez.Model.AccountBuilder;
import com.github.nez.Respository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        account = new AccountBuilder().setUsername(account.getUsername()).setPassword(account.getPassword()).setEmail(account.getEmail()).createAccount();
        return this.accountRepository.save(account);
    }

    public Optional<Account> login(Account account){
        String id = accountRepository.findUserId(account.getUsername(),account.getPassword());
        if(accountRepository.existsById(id)){
            return accountRepository.findById(id);
        }
        else{
            return Optional.of(new AccountBuilder().setUsername("user does not exist").createAccount());
        }
    }

    public Account addFriend(String ourIds) {
        String[] id = ourIds.split(",");
        String friendId = id[0];
        String myId = id[1];
        if (accountRepository.existsById(friendId)) {
            Account friendsAccount = accountRepository.findById(friendId).get();
            Account myAccount = accountRepository.findById(myId).get();
            myAccount.addFriend(friendsAccount);
            return accountRepository.save(myAccount);
        }
        else{
            System.out.println("sorry that account does not exist.");
           return null;
        }
    }

    public ArrayList<Account> getFriends(Account account){
        account = accountRepository.findById(account.getId()).get();
        return account.getFriends();
    }

    public Account find(String id) {
    return accountRepository.findById(id).get();
    }
}

