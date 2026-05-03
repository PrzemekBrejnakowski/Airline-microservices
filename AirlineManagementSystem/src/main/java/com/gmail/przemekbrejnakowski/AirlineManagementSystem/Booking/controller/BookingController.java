package com.gmail.przemekbrejnakowski.AirlineManagementSystem.Booking.controller;

import com.gmail.przemekbrejnakowski.AirlineManagementSystem.Booking.model.Booking;
import com.gmail.przemekbrejnakowski.AirlineManagementSystem.Booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBooking() {
        return bookingService.get();
    }

    @GetMapping("{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        Booking booking = bookingService.get(id);
        return ResponseEntity.ok().body(booking);
    }

    @PostMapping("")
    public ResponseEntity<?>save(@RequestBody Booking booking) {
        bookingService.save(booking);
        return ResponseEntity.ok().body("Booking created with id: " + booking.getId());
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Booking booking) {
        bookingService.update(id, booking);
        return ResponseEntity.ok().body("Success");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?>delete(@PathVariable Long id) {
        bookingService.delete(id);
        return ResponseEntity.ok().body("Success");
    }


}
