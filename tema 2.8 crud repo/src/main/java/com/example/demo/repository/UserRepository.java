package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {
//    public User getByUsernameAndPassword(String username, String password);
//    public Optional<User> findByUsernameAndPassword(String username, String password);
    public Optional<User> findFirstByUsernameAndPassword(String username, String password);
}
