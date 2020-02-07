package com.github.nez.repository;

import com.github.nez.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,String> {

}
