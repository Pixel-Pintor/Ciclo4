package com.reto2.repository.crud;

import com.reto2.model.Peripheral;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeripheralCrudRepository extends MongoRepository<Peripheral, String> {
    
}
