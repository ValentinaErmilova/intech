package com.example.intech.DAO;

import com.example.intech.models.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageDAO extends CrudRepository<Message, Long> {
    @Query("SELECT m FROM Message m WHERE m.toUser.id = ?1")
    List<Message> findByToUserId(Long toUserId);
}
