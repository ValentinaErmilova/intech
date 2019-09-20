package com.example.intech.DAO;

import com.example.intech.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByName(String name);
}