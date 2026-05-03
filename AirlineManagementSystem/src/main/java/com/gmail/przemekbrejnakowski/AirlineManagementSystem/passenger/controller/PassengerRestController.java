package com.gmail.przemekbrejnakowski.AirlineManagementSystem.passenger.controller;

import com.gmail.przemekbrejnakowski.AirlineManagementSystem.passenger.model.Passenger;
import com.gmail.przemekbrejnakowski.AirlineManagementSystem.passenger.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerRestController {

    private final PassengerService passengerService;

    public PassengerRestController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public Passenger register(@RequestBody Passenger passenger) {
        return passengerService.registerPassenger(passenger);
    }

    @GetMapping("/{id}")
    public Passenger getPassenger(@PathVariable("id") Long id) {
        return passengerService.getPassenger(id);
    }

    @GetMapping("")
    public List<Passenger> getAllPassenger() {
        return passengerService.getAllPassenger();
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Passenger passenger) {
        passengerService.registerPassenger(passenger);
        return ResponseEntity.ok().body("Booking created with id: " + passenger.getId());
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Passenger passenger) {
        passengerService.update(id, passenger);
        return ResponseEntity.ok().body("Success");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?>delete(@PathVariable Long id) {
        passengerService.delete(id);
        return ResponseEntity.ok().body("Success");
    }
}
