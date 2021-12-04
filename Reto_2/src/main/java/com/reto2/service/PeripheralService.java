package com.reto2.service;

import com.reto2.model.Peripheral;
import com.reto2.repository.PeripheralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeripheralService {

    @Autowired
    private PeripheralRepository peripheralRepository;

    public List<Peripheral> listPeripherals() {
        return peripheralRepository.getPeripherals();
    }

    public Peripheral createPeripheral(Peripheral peripheral) {
        if (peripheral.getReference() == null) {
            return peripheralRepository.create(peripheral);
        } else {
            Optional<Peripheral> periAux = peripheralRepository.getPeripheralByReference(peripheral.getReference());
            if (periAux.isEmpty()) {
                return peripheralRepository.createPeripheral(peripheral);
            } else {
                return peripheral;
            }
        }
    }

    public Peripheral updatePeripheral(Peripheral peripheral) {
        if (peripheral.getReference() != null) {
            Optional<Peripheral> peripheralCheck = peripheralRepository.getPeripheralByReference(peripheral.getReference());
            if (peripheralCheck.isPresent()) {
                if (peripheral.getCategory() != null) {
                    peripheralCheck.get().setCategory(peripheral.getCategory());
                }
                if (peripheral.getDescription() != null) {
                    peripheralCheck.get().setDescription(peripheral.getDescription());
                }
                if (peripheral.getPrice() != null) {
                    peripheralCheck.get().setPrice(peripheral.getPrice());
                }
                if (peripheral.getAvailability() != null) {
                    peripheralCheck.get().setAvailability(peripheral.getAvailability());
                }
                if (peripheral.getQuantity() != null) {
                    peripheralCheck.get().setQuantity(peripheral.getQuantity());
                }
                if (peripheral.getPhotography() != null) {
                    peripheralCheck.get().setPhotography(peripheral.getPhotography());
                }

                peripheralRepository.update(peripheralCheck.get());
                return peripheralCheck.get();
            } else {
                return peripheral;
            }
        } else {
            return peripheral;
        }
    }

    public boolean deletePeripheral(String reference) {
        return peripheralRepository.getPeripheralByReference(reference).map(peripheral -> {
            peripheralRepository.deletePeripheral(reference);
            return true;
        }).orElse(false);
    }
}
