package com.c4reto4.repository;

import com.c4reto4.model.User;
import com.c4reto4.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository crudInterface;

    public Optional<User> getUser(int id) {
        return crudInterface.findById(id);
    }

    public List<User> listAll() {
        return crudInterface.findAll();
    }

    public boolean emailExists(String email) {
        Optional<User> user = crudInterface.findByEmail(email);

        return user.isPresent();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return crudInterface.findByEmailAndPassword(email, password);
    }

    public User create(User user) {
        return crudInterface.save(user);
    }
    
    public void update(User user) {
        crudInterface.save(user);
    }
    
    
    public void delete(User user) {
        crudInterface.delete(user);
    }
    
    public Optional<User> lastUserId(){
        return crudInterface.findTopByOrderByIdDesc();
    }
     
    public List<User> birthtDayList(String monthBirthtDay) {
        return crudInterface.findByMonthBirthtDay(monthBirthtDay);
    }
}
