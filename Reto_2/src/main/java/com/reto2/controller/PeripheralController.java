package com.reto2.controller;

import com.reto2.model.Peripheral;
import com.reto2.service.PeripheralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peripherals")
public class PeripheralController {

    @Autowired
    private PeripheralService peripheralService;

    @GetMapping("/all")
    public List<Peripheral> getListPeripherals() {
        return peripheralService.listPeripherals();
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
