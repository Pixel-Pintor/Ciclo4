package com.reto2.repository;

import com.reto2.model.Peripheral;
import com.reto2.repository.crud.PeripheralCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeripheralRepository {

    @Autowired
    private PeripheralCrudRepository peripheralCrudRepository;

    public List<Peripheral> getPeripherals() {
        return peripheralCrudRepository.findAll();
    }

    public Peripheral createPeripheral(Peripheral peripheral) {
        return peripheralCrudRepository.save(peripheral);
    }

    public Optional<Peripheral> getPeripheralByReference(String reference) {
        return peripheralCrudRepository.findByReference(reference);
    }

    public Peripheral create(Peripheral peripheral) {
        return peripheralCrudRepository.save(peripheral);
    }
    
    public void update(Peripheral peripheral) {
        peripheralCrudRepository.save(peripheral);
    }

    public void deletePeripheral(String reference) {
        peripheralCrudRepository.deleteByReference(reference);
    }
}
