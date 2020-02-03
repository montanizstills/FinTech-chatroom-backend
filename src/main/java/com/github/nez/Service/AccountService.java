package com.github.nez.Service;

import com.github.nez.Model.Account;
import com.github.nez.Model.AccountBuilder;
import com.github.nez.Respository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class AccountService {

    @Qualifier("myentitymanager")
   final private EntityManager entityManager;
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, EntityManager entityManager) {
        this.accountRepository = accountRepository;
        this.entityManager = entityManager;
    }

    public Account createAccount(Account account) {
        account = new AccountBuilder().setUsername(account.getUsername()).setPassword(account.getPassword()).setEmail(account.getEmail()).createAccount();
        return this.accountRepository.save(account);
    }

    public Account login(Account incomingLoginAttempt){
//        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(this.entityManager);
//        QAccount accountPersistentBean = QAccount.account;
//        incomingLoginAttempt = jpaQueryFactory
//                .selectFrom(accountPersistentBean)
//                .where(
//                        accountPersistentBean.username.eq(incomingLoginAttempt.getUsername()),
//                        accountPersistentBean.password.eq(incomingLoginAttempt.getPassword())
//                )
//                .fetchOne();
//      return incomingLoginAttempt;
        return accountRepository.findIdByUserPass(incomingLoginAttempt.getUsername(),incomingLoginAttempt.getPassword());

    }

//    public Account addFriend(String ourIds) {
//        String[] id = ourIds.split(",");
//        String friendId = id[0];
//        String myId = id[1];
//        if (accountRepository.existsById(friendId)) {
//            Account friendsAccount = accountRepository.findById(friendId).get();
//            Account myAccount = accountRepository.findById(myId).get();
//            myAccount.addFriend(friendsAccount);
//            return accountRepository.save(myAccount);
//        }
//        else{
//            System.out.println("sorry that account does not exist.");
//           return null;
//        }
//    }

//    public ArrayList<Account> getFriends(Account account){
//        account = accountRepository.findById(account.getId()).get();
//        return account.getFriends();
//    }

    public Account find(String id) {
    return accountRepository.findById(id).get();
    }
}

