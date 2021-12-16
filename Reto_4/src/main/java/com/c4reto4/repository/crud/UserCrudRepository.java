package com.c4reto4.repository.crud;

import com.c4reto4.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    List<User> findByMonthBirthtDay(String monthBirthtDay);

    Optional<User> findTopByOrderByIdDesc();
}
