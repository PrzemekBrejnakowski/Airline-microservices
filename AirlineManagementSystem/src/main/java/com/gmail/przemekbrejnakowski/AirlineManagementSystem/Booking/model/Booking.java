package com.gmail.przemekbrejnakowski.AirlineManagementSystem.Booking.model;

import com.gmail.przemekbrejnakowski.AirlineManagementSystem.flight.model.Flight;
import com.gmail.przemekbrejnakowski.AirlineManagementSystem.passenger.model.Passenger;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Flight flight;

    private boolean checkedIn;

    public Booking() {
    }

    public Booking(Long id, Passenger passenger, Flight flight, boolean checkedIn) {
        this.id = id;
        this.passenger = passenger;
        this.flight = flight;
        this.checkedIn = checkedIn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", flight=" + flight +
                ", checkedIn=" + checkedIn +
                '}';
    }
}
