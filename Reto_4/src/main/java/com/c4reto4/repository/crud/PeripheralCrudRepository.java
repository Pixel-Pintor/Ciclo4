package com.c4reto4.repository.crud;

import com.c4reto4.model.Peripheral;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PeripheralCrudRepository extends MongoRepository<Peripheral, String> {

    List<Peripheral> findByPriceLessThanEqual(double price);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    List<Peripheral> findByDescriptionLike(String description);
}
