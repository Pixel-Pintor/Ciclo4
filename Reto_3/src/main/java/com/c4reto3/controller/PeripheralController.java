package com.c4reto3.controller;

import com.c4reto3.model.Peripheral;
import com.c4reto3.service.PeripheralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peripherals")
@CrossOrigin("*")
public class PeripheralController {

    @Autowired
    private PeripheralService peripheralService;

    @GetMapping("/all")
    public List<Peripheral> listAllPeripherals() {
        return peripheralService.listAll();
    }

    @GetMapping("/{reference}")
    public Optional<Peripheral> getPeripheral(@PathVariable("reference") String reference) {
        return peripheralService.getPeripheral(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral createPeripheral(@RequestBody Peripheral peripheral) {
        return peripheralService.createPeripheral(peripheral);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral updatePeripheral(@RequestBody Peripheral peripheral) {
        return peripheralService.updatePeripheral(peripheral);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deletePeripheral(@PathVariable("reference") String reference) {
        return peripheralService.deletePeripheral(reference);
    }
}