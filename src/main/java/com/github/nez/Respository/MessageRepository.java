package com.github.nez.Respository;

import com.github.nez.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,String> {
}
