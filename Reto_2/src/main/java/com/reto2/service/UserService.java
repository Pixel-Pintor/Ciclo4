package com.reto2.service;

import com.reto2.model.User;
import com.reto2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers() {
        return userRepository.getUsers();
    }

    public boolean checkUserEmail(String email) {
        return userRepository.checkEmail(email);
    }

    public User checkUserEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.checkEmailAndPassword(email, password);

        if (user.isEmpty()) {
            return new User();
        } else {
            return user.get();
        }
    }

    public User createUser(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> getUser = userRepository.getUserById(user.getId());
            if (getUser.isEmpty()) {
                if (!checkUserEmail(user.getEmail())) {
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    public User updateUser(User user) {
        if (user.getId() != null) {
            Optional<User> userCheck = userRepository.getUserById(user.getId());
            if (userCheck.isPresent()) {
                if (user.getIdentification() != null) {
                    userCheck.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userCheck.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userCheck.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userCheck.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userCheck.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userCheck.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userCheck.get().setZone(user.getZone());
                }

                userRepository.update(userCheck.get());
                return userCheck.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean deleteUser(int id) {
        return userRepository.getUserById(id).map(user -> {
            userRepository.deleteUser(id);
            return true;
        }).orElse(false);
    }
}
