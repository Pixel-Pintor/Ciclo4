package com.c4reto3.repository;

import com.c4reto3.model.Peripheral;
import com.c4reto3.repository.crud.PeripheralCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeripheralRepository {

    @Autowired
    private PeripheralCrudRepository peripheralCrudRepository;

    public List<Peripheral> listAllPeripherals() {
        return peripheralCrudRepository.findAll();
    }

    public Optional<Peripheral> getPeripheral(String reference) {
        return peripheralCrudRepository.findById(reference);
    }

    public Peripheral createPeripheral(Peripheral peripheral) {
        return peripheralCrudRepository.save(peripheral);
    }

    public void updatePeripheral(Peripheral peripheral) {
        peripheralCrudRepository.save(peripheral);
    }

    public void deletePeripheral(Peripheral peripheral) {
        peripheralCrudRepository.delete(peripheral);
    }
}
