package com.reto2.repository.crud;

import com.reto2.model.Peripheral;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PeripheralCrudRepository extends MongoRepository<Peripheral, String> {

    Optional<Peripheral> findByReference(String reference);

    void deleteByReference(String reference);
}
