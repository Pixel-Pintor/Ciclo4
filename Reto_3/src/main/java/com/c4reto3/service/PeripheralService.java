package com.c4reto3.service;

import com.c4reto3.model.Peripheral;
import com.c4reto3.repository.PeripheralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeripheralService {

    @Autowired
    private PeripheralRepository peripheralRepository;

    public List<Peripheral> listAll() {
        return peripheralRepository.listAllPeripherals();
    }

    public Optional<Peripheral> getPeripheral(String reference) {
        return peripheralRepository.getPeripheral(reference);
    }

    public Peripheral createPeripheral(Peripheral peripheral) {
        if (peripheral.getReference() == null) {
            return peripheral;
        } else {
            return peripheralRepository.createPeripheral(peripheral);
        }
    }

    public Peripheral updatePeripheral(Peripheral peripheral) {

        if (peripheral.getReference() != null) {
            Optional<Peripheral> supplementDb = peripheralRepository.getPeripheral(peripheral.getReference());
            if (supplementDb.isPresent()) {
                if (peripheral.getBrand() != null) {
                    supplementDb.get().setBrand(peripheral.getBrand());
                }
                if (peripheral.getCategory() != null) {
                    supplementDb.get().setCategory(peripheral.getCategory());
                }
                if (peripheral.getDescription() != null) {
                    supplementDb.get().setDescription(peripheral.getDescription());
                }
                if (peripheral.getPrice() != 0.0) {
                    supplementDb.get().setPrice(peripheral.getPrice());
                }
                if (peripheral.getQuantity() != 0) {
                    supplementDb.get().setQuantity(peripheral.getQuantity());
                }
                if (peripheral.getPhotography() != null) {
                    supplementDb.get().setPhotography(peripheral.getPhotography());
                }
                supplementDb.get().setAvailability(peripheral.isAvailability());
                peripheralRepository.updatePeripheral(supplementDb.get());
                return supplementDb.get();
            } else {
                return peripheral;
            }
        } else {
            return peripheral;
        }
    }

    public boolean deletePeripheral(String reference) {
        return getPeripheral(reference).map(supplement -> {
            peripheralRepository.deletePeripheral(supplement);
            return true;
        }).orElse(false);
    }
}