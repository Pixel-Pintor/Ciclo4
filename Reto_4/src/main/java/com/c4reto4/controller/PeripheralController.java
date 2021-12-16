package com.c4reto4.controller;

import com.c4reto4.model.Peripheral;
import com.c4reto4.service.PeripheralService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/peripherals")
@CrossOrigin("*")
public class PeripheralController {

    @Autowired
    private PeripheralService peripheralService;

    @GetMapping("/all")
    public List<Peripheral> listAll() {
        return peripheralService.listAll();
    }

    @GetMapping("/{reference}")
    public Optional<Peripheral> getSupplement(@PathVariable("reference") String reference) {
        return peripheralService.getPeripheral(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral create(@RequestBody Peripheral peripheral) {
        return peripheralService.create(peripheral);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral update(@RequestBody Peripheral peripheral) {
        return peripheralService.update(peripheral);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return peripheralService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Peripheral> peripheralsByPrice(@PathVariable("price") double price) {
        return peripheralService.peripheralsByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Peripheral> findByDescriptionLike(@PathVariable("description") String description) {
        return peripheralService.findByDescriptionLike(description);
    }
}
