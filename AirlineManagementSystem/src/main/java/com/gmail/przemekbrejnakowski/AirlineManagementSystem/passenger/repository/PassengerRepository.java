package com.gmail.przemekbrejnakowski.AirlineManagementSystem.passenger.repository;

import com.gmail.przemekbrejnakowski.AirlineManagementSystem.passenger.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {


    Optional<Passenger> findByPassportNumber(String passportNumber);
}
