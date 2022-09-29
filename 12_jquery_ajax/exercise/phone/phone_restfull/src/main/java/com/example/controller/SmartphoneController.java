package com.example.controller;

import com.example.model.Smartphone;
import com.example.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> findById(@PathVariable Long id) {
        if (!smartphoneService.findById(id).isPresent()){
            return new ResponseEntity<>(smartphoneService.findById(id).get(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneService.findById(id).get(), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Smartphone>> getAllSmartphonePage() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> updateBlog(@PathVariable Long id,
                                                 @RequestBody Smartphone smartphone) {
        Smartphone currentSmartphone = smartphoneService.findById(id).get();
        if (currentSmartphone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentSmartphone.setModel(smartphone.getModel());
        currentSmartphone.setPrice(smartphone.getPrice());
        currentSmartphone.setProducer(smartphone.getProducer());

        smartphoneService.save(currentSmartphone);
        return new ResponseEntity<>(currentSmartphone, HttpStatus.OK);
    }
}
