package com.c4reto3.repository;

import com.c4reto3.model.User;
import com.c4reto3.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAllUsers() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userCrudRepository.findById(id);
    }

    public User createUser(User user) {
        return userCrudRepository.save(user);
    }

    public void updateUser(User user) {
        userCrudRepository.save(user);
    }

    public void deleteUser(User user) {
        userCrudRepository.delete(user);
    }

    public boolean existUserEmail(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return user.isPresent();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> lastUserId() {
        return userCrudRepository.findTopByOrderByIdDesc();
    }
}
