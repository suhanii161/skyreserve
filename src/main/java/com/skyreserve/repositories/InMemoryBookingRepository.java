package com.skyreserve.repositories;

import com.skyreserve.models.Booking;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookingRepository {
    private final List<Booking> bookings = new ArrayList<>();

    public void save(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> findAll() {
        return bookings;
    }

    public Optional<Booking> findByPnr(String pnr) {
        return bookings.stream()
                .filter(b -> b.getPnr().equalsIgnoreCase(pnr))
                .findFirst();
    }
    
    public List<Booking> findByUsername(String username) {
        return bookings.stream()
                .filter(b -> b.getCustomer().getUsername().equals(username))
                .toList();
    }
}
