package com.github.nez.Respository;

import com.github.nez.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;

@Repository
public interface AccountRepository extends CrudRepository<Account,String>, QuerydslPredicateExecutor{

    @Query(nativeQuery = true, value = "SELECT * FROM Account a WHERE a.username=:username and a.password=:password")
    Account findIdByUserPass(@Param("username") String username, @Param("password") String password);


}
