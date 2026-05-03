package com.gmail.przemekbrejnakowski.AirlineManagementSystem.flight.service;

import com.gmail.przemekbrejnakowski.AirlineManagementSystem.flight.model.Flight;
import com.gmail.przemekbrejnakowski.AirlineManagementSystem.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber).orElseThrow(() -> new RuntimeException("Nie znaleziono lotu o numerze: " + flightNumber));
    }

    public List<Flight> getFlightByDestination(String destination) {
        return flightRepository.findByDestination(destination);
    }

    public List<Flight> getFlightByDepartureTime(LocalDateTime departureTime) {
        return flightRepository.findByDepartureTime(departureTime);
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono lotu o ID: " + id));
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        Flight flightObj = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono lotu o ID: " + id));
        flightObj.setFlightNumber(flight.getFlightNumber());
        flightObj.setOrigin(flight.getOrigin());
        flightObj.setDestination(flight.getDestination());
        flightObj.setDepartureTime(flight.getDepartureTime());
        flightObj.setAvailableSeats(flight.getAvailableSeats());
        flightRepository.save(flightObj);
        return flightObj;
    }

    public void deleteFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new RuntimeException("Nie znaleziono lotu o ID: " + id);
        }
        flightRepository.deleteById(id);
    }
}