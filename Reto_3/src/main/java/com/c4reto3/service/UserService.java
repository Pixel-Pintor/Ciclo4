package com.c4reto3.service;

import com.c4reto3.model.User;
import com.c4reto3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public User createUser(User user) {

        Optional<User> maxUserId = userRepository.lastUserId();

        if (user.getId() == null) {
            if (maxUserId.isEmpty()) {
                user.setId(1);
            } else {
                user.setId(maxUserId.get().getId() + 1);
            }
        }

        Optional<User> e = userRepository.getUserById(user.getId());
        if (e.isEmpty()) {
            if (!userRepository.existUserEmail(user.getEmail())) {
                return userRepository.createUser(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public User updateUser(User user) {
        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUserById(user.getId());
            if (userDb.isPresent()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getBirthtDay() != null) {
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay() != null) {
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    userDb.get().setType(user.getType());
                }
                userRepository.updateUser(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean deleteUser(int id) {
        return getUserById(id).map(user ->{
            userRepository.deleteUser(user);
            return true;
        }).orElse(false);
    }

    public boolean checkEmail(String email) {
        return userRepository.existUserEmail(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> user = userRepository.authenticateUser(email, password);
        if (user.isEmpty()) {
            return new User();
        } else {
            return user.get();
        }
    }
}
