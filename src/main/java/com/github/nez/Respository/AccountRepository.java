package com.github.nez.Respository;

import com.github.nez.Model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,String> {

//    @Query(nativeQuery = true, value = "SELECT id FROM Account a WHERE a.username=:username and a.password=:password")
//    String findUserId(@Param("username") String username, @Param("password") String password);


}
