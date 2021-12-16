package com.c4reto4.repository;

import com.c4reto4.model.Peripheral;
import com.c4reto4.repository.crud.PeripheralCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PeripheralRepository {

    @Autowired
    private PeripheralCrudRepository crudInterface;

    public List<Peripheral> listAll() {
        return crudInterface.findAll();
    }

    public Optional<Peripheral> getPeripheral(String reference) {
        return crudInterface.findById(reference);
    }

    public Peripheral create(Peripheral peripheral) {
        return crudInterface.save(peripheral);
    }

    public void update(Peripheral peripheral) {
        crudInterface.save(peripheral);
    }

    public void delete(Peripheral peripheral) {
        crudInterface.delete(peripheral);
    }

    public List<Peripheral> peripheralsByPrice(double price) {
        return crudInterface.findByPriceLessThanEqual(price);
    }

    public List<Peripheral> findByDescriptionLike(String description) {
        return crudInterface.findByDescriptionLike(description);
    }
}
