package com.reto2.repository;

import com.reto2.model.Peripheral;
import com.reto2.repository.crud.PeripheralCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PeripheralRepository {

    @Autowired
    private PeripheralCrudRepository peripheralCrudRepository;

    public List<Peripheral> listAll() {
        return peripheralCrudRepository.findAll();
    }

    public Optional<Peripheral> getPeripheral(String reference) {
        return peripheralCrudRepository.findById(reference);
    }

    public Peripheral create(Peripheral peripheral) {
        return peripheralCrudRepository.save(peripheral);
    }

    public void update(Peripheral peripheral) {
        peripheralCrudRepository.save(peripheral);
    }

    public void delete(Peripheral peripheral) {
        peripheralCrudRepository.delete(peripheral);
    }
}
