package com.skyreserve.models;

import java.time.LocalDateTime;

public class Flight {
    private String flightNumber;
    private Airline airline;
    private Airport origin;
    private Airport destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double basePrice;
    private int availableSeats;
    private int totalSeats;
    private int stops;
    
    // Additional metrics for USP #1
    private boolean onTimePerformanceGood; // mock stat
    private boolean extraBaggage; // mock stat
    private boolean comfortableTiming; // mock stat

    public Flight(String flightNumber, Airline airline, Airport origin, Airport destination, 
                  LocalDateTime departureTime, LocalDateTime arrivalTime, double basePrice, 
                  int totalSeats, int stops) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.basePrice = basePrice;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // starts fully empty
        this.stops = stops;
        
        // mock defaults
        this.onTimePerformanceGood = true;
        this.extraBaggage = false;
        this.comfortableTiming = true;
    }

    // Getters and Setters
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public Airline getAirline() { return airline; }
    public void setAirline(Airline airline) { this.airline = airline; }

    public Airport getOrigin() { return origin; }
    public void setOrigin(Airport origin) { this.origin = origin; }

    public Airport getDestination() { return destination; }
    public void setDestination(Airport destination) { this.destination = destination; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }

    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

    public int getStops() { return stops; }
    public void setStops(int stops) { this.stops = stops; }

    public boolean isOnTimePerformanceGood() { return onTimePerformanceGood; }
    public void setOnTimePerformanceGood(boolean onTimePerformanceGood) { this.onTimePerformanceGood = onTimePerformanceGood; }

    public boolean isExtraBaggage() { return extraBaggage; }
    public void setExtraBaggage(boolean extraBaggage) { this.extraBaggage = extraBaggage; }

    public boolean isComfortableTiming() { return comfortableTiming; }
    public void setComfortableTiming(boolean comfortableTiming) { this.comfortableTiming = comfortableTiming; }
}
