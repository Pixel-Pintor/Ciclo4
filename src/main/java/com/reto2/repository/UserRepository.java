package com.reto2.repository;

import com.reto2.model.User;
import com.reto2.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getUsers() {
        return userCrudRepository.findAll();
    }

    public boolean checkEmail(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);

        return user.isPresent();
    }

    public Optional<User> checkEmailAndPassword(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUserById(int id) {
        return userCrudRepository.findById(id);
    }

    public User create(User user) {
        return userCrudRepository.save(user);
    }

    public void update(User user) {
        userCrudRepository.save(user);
    }

    public void deleteUser(int id) {
        userCrudRepository.deleteById(id);
    }
}
