package com.gmail.przemekbrejnakowski.AirlineManagementSystem.Booking.dao;

import com.gmail.przemekbrejnakowski.AirlineManagementSystem.Booking.model.Booking;

import java.util.List;

public interface BookingDao {
    List<Booking> get();
    Booking get(Long id);
    Long save(Booking booking);
    void update(Long id, Booking booking);
    void delete(Long id);
}
