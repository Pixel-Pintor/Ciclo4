package com.reto2.service;

import com.reto2.model.Peripheral;
import com.reto2.repository.PeripheralRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeripheralService {

    @Autowired
    private PeripheralRepository peripheralRepository;

    public List<Peripheral> listAll() {
        return peripheralRepository.listAll();
    }

    public Optional<Peripheral> getSupplement(String reference) {
        return peripheralRepository.getPeripheral(reference);
    }

    public Peripheral create(Peripheral supplement) {
        if (supplement.getReference() == null) {
            return supplement;
        } else {
            return peripheralRepository.create(supplement);
        }
    }

    public Peripheral update(Peripheral peripheral) {

        if (peripheral.getReference() != null) {
            Optional<Peripheral> supplementDb = peripheralRepository.getPeripheral(peripheral.getReference());
            if (!supplementDb.isEmpty()) {
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
                peripheralRepository.update(supplementDb.get());
                return supplementDb.get();
            } else {
                return peripheral;
            }
        } else {
            return peripheral;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getSupplement(reference).map(supplement -> {
            peripheralRepository.delete(supplement);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
