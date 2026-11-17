package com.skyreserve.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String pnr;
    private User customer;
    private Flight flight;
    private List<Passenger> passengers;
    private double totalAmount;
    private String status; // "Confirmed", "Cancelled", "Pending"
    private LocalDateTime bookingTime;

    public Booking(String pnr, User customer, Flight flight) {
        this.pnr = pnr;
        this.customer = customer;
        this.flight = flight;
        this.passengers = new ArrayList<>();
        this.status = "Pending";
        this.bookingTime = LocalDateTime.now();
    }

    public String getPnr() { return pnr; }
    public void setPnr(String pnr) { this.pnr = pnr; }

    public User getCustomer() { return customer; }
    public void setCustomer(User customer) { this.customer = customer; }

    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }

    public List<Passenger> getPassengers() { return passengers; }
    public void addPassenger(Passenger p) { this.passengers.add(p); }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }
}
