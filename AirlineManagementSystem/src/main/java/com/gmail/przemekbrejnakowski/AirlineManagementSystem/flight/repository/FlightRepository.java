package com.gmail.przemekbrejnakowski.AirlineManagementSystem.flight.repository;

import com.gmail.przemekbrejnakowski.AirlineManagementSystem.flight.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightNumber(String flightNumber);

    List<Flight> findByDestination(String destination);

    List<Flight> findByDepartureTime(LocalDateTime departureTime);
}
