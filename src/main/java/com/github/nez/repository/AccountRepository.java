package com.github.nez.repository;

import com.github.nez.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,String>{

    @Query( value = "SELECT a.id FROM Account a WHERE a.username=:username and a.password=:password")
    Account findIdByUserPass(@Param("username") String username, @Param("password") String password);


}
