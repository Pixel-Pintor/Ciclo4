package com.c4reto4.service;

import com.c4reto4.model.Peripheral;
import com.c4reto4.repository.PeripheralRepository;
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

    public Optional<Peripheral> getPeripheral(String reference) {
        return peripheralRepository.getPeripheral(reference);
    }

    public Peripheral create(Peripheral peripheral) {
        if (peripheral.getReference() == null) {
            return peripheral;
        } else {
            return peripheralRepository.create(peripheral);
        }
    }

    public Peripheral update(Peripheral peripheral) {

        if (peripheral.getReference() != null) {
            Optional<Peripheral> peripheralDb = peripheralRepository.getPeripheral(peripheral.getReference());
            if (peripheralDb.isPresent()) {
                if (peripheral.getBrand() != null) {
                    peripheralDb.get().setBrand(peripheral.getBrand());
                }
                if (peripheral.getCategory() != null) {
                    peripheralDb.get().setCategory(peripheral.getCategory());
                }
                if (peripheral.getDescription() != null) {
                    peripheralDb.get().setDescription(peripheral.getDescription());
                }
                if (peripheral.getPrice() != 0.0) {
                    peripheralDb.get().setPrice(peripheral.getPrice());
                }
                if (peripheral.getQuantity() != 0) {
                    peripheralDb.get().setQuantity(peripheral.getQuantity());
                }
                if (peripheral.getPhotography() != null) {
                    peripheralDb.get().setPhotography(peripheral.getPhotography());
                }
                peripheralDb.get().setAvailability(peripheral.isAvailability());
                peripheralRepository.update(peripheralDb.get());
                return peripheralDb.get();
            } else {
                return peripheral;
            }
        } else {
            return peripheral;
        }
    }

    public boolean delete(String reference) {
        return getPeripheral(reference).map(peripheral -> {
            peripheralRepository.delete(peripheral);
            return true;
        }).orElse(false);
    }

    public List<Peripheral> peripheralsByPrice(double price) {
        return peripheralRepository.peripheralsByPrice(price);
    }

    public List<Peripheral> findByDescriptionLike(String description) {
        return peripheralRepository.findByDescriptionLike(description);
    }
}
