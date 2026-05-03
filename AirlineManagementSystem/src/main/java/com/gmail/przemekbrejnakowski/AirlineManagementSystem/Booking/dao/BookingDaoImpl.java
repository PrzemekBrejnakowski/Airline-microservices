package com.gmail.przemekbrejnakowski.AirlineManagementSystem.Booking.dao;

import com.gmail.przemekbrejnakowski.AirlineManagementSystem.Booking.model.Booking;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public class BookingDaoImpl implements BookingDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Booking> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Booking> query = currentSession.createQuery("from Booking", Booking.class);
        List<Booking> list = query.getResultList();
        return list;
    }

    @Override
    public Booking get(Long id) {
        return entityManager.find(Booking.class, id);
    }

    @Override
    public Long save(Booking booking) {
        if(booking.getId() == 0) {
            entityManager.persist(booking);
        } else {
            entityManager.merge(booking);
        }
        return booking.getId();
        }

    @Override
    public void update(Long id, Booking booking) {
        Booking bookingOld = entityManager.find(Booking.class, id);
        bookingOld.setPassenger(booking.getPassenger());
        bookingOld.setFlight(booking.getFlight());
        bookingOld.setCheckedIn(booking.isCheckedIn());
        entityManager.merge(bookingOld);
    }

    @Override
    public void delete(Long id) {
        Booking booking = entityManager.find(Booking.class, id);
        entityManager.remove(booking);
    }
}
