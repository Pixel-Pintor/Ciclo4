package com.c4reto3.repository.crud;

import com.c4reto3.model.Peripheral;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeripheralCrudRepository extends MongoRepository<Peripheral, String> {
}
