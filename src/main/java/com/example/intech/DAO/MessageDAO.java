package com.example.intech.DAO;

import com.example.intech.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageDAO extends CrudRepository<Message, Integer> {
}
