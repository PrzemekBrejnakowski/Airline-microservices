package com.gmail.przemekbrejnakowski.AirlineManagementSystem.passenger.service;

import com.gmail.przemekbrejnakowski.AirlineManagementSystem.flight.model.Flight;
import com.gmail.przemekbrejnakowski.AirlineManagementSystem.passenger.model.Passenger;
import com.gmail.przemekbrejnakowski.AirlineManagementSystem.passenger.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;


    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger registerPassenger(Passenger passenger) {
        passengerRepository.findByPassportNumber(
                passenger.getPassportNumber()).ifPresent(p -> {
                    throw new RuntimeException(
                            "Pasażer z tym numerem paszportu już istnieje.");
                });

        return passengerRepository.save(passenger);
    }

    public Passenger getPassenger(Long id) {
        return passengerRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono pasażera."));
    }

    public Passenger findByPassportNumber(String passNumber) {
        return passengerRepository.findByPassportNumber(passNumber)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono pasażera o numerze paszportu: " + passNumber));
    }

    public List<Passenger> getAllPassenger() {
        return passengerRepository.findAll();
    }

    public Passenger update(Long id, Passenger passenger) {
        Passenger passengerObj = passengerRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono pasażera o ID: " + id));
        passengerObj.setFirstName(passenger.getFirstName());
        passengerObj.setLastName(passenger.getLastName());
        passengerObj.setEmail(passenger.getEmail());
        passengerObj.setPassportNumber(passenger.getPassportNumber());
        passengerRepository.save(passengerObj);
        return passengerObj;
    }

    public void delete(Long id) {
        if (!passengerRepository.existsById(id)) {
            throw new RuntimeException("Nie znaleziono pasażera o ID: " + id);
        }
        passengerRepository.deleteById(id);
    }
}
