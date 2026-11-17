package com.skyreserve.repositories;

import com.skyreserve.models.Airline;
import com.skyreserve.models.Airport;
import com.skyreserve.models.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryFlightRepository {
    private final List<Flight> flights = new ArrayList<>();
    private final List<Airport> airports = new ArrayList<>();
    private final List<Airline> airlines = new ArrayList<>();

    public InMemoryFlightRepository() {
        initAirports();
        initAirlines();
        initFlights();
    }

    private void initAirports() {
        airports.add(new Airport("DEL", "Delhi", "Indira Gandhi International Airport"));
        airports.add(new Airport("BOM", "Mumbai", "Chhatrapati Shivaji Maharaj International Airport"));
        airports.add(new Airport("BLR", "Bengaluru", "Kempegowda International Airport"));
        airports.add(new Airport("GOA", "Goa", "Dabolim Airport"));
        airports.add(new Airport("HYD", "Hyderabad", "Rajiv Gandhi International Airport"));
    }

    private void initAirlines() {
        airlines.add(new Airline("6E", "IndiGo"));
        airlines.add(new Airline("AI", "Air India"));
        airlines.add(new Airline("UK", "Vistara"));
        airlines.add(new Airline("SG", "SpiceJet"));
        airlines.add(new Airline("QP", "Akasa Air"));
    }

    private void initFlights() {
        // Base date for mock flights (e.g., 20 Sep 2026 as per prompt)
        LocalDateTime baseDate = LocalDateTime.of(2026, 9, 20, 0, 0);

        // DEL to BOM flights (as per UI reference)
        Flight f1 = new Flight("6E-204", getAirline("6E"), getAirport("DEL"), getAirport("BOM"),
                baseDate.withHour(6).withMinute(30), baseDate.withHour(8).withMinute(40), 5240, 180, 0);
        f1.setOnTimePerformanceGood(true);
        f1.setComfortableTiming(true);

        Flight f2 = new Flight("AI-865", getAirline("AI"), getAirport("DEL"), getAirport("BOM"),
                baseDate.withHour(9).withMinute(15), baseDate.withHour(11).withMinute(45), 5650, 220, 0);
        f2.setExtraBaggage(true);

        Flight f3 = new Flight("UK-955", getAirline("UK"), getAirport("DEL"), getAirport("BOM"),
                baseDate.withHour(13).withMinute(20), baseDate.withHour(16).withMinute(10), 6180, 160, 0);
        
        Flight f4 = new Flight("SG-312", getAirline("SG"), getAirport("DEL"), getAirport("BOM"),
                baseDate.withHour(18).withMinute(45), baseDate.withHour(21).withMinute(20), 4980, 180, 0);

        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);
        
        // Add more routes for testing
        flights.add(new Flight("6E-502", getAirline("6E"), getAirport("BOM"), getAirport("BLR"),
                baseDate.withHour(7).withMinute(0), baseDate.withHour(8).withMinute(30), 4200, 180, 0));
        
        flights.add(new Flight("UK-921", getAirline("UK"), getAirport("DEL"), getAirport("GOA"),
                baseDate.withHour(10).withMinute(0), baseDate.withHour(12).withMinute(30), 7500, 160, 0));
    }

    public Airport getAirport(String code) {
        return airports.stream().filter(a -> a.getCode().equals(code)).findFirst().orElse(null);
    }
    
    public Airline getAirline(String code) {
        return airlines.stream().filter(a -> a.getCode().equals(code)).findFirst().orElse(null);
    }

    public List<Airport> getAllAirports() {
        return airports;
    }
    
    public List<Flight> getAllFlights() {
        return flights;
    }

    public List<Flight> searchFlights(String originCode, String destinationCode, LocalDateTime date) {
        return flights.stream()
                .filter(f -> f.getOrigin().getCode().equals(originCode))
                .filter(f -> f.getDestination().getCode().equals(destinationCode))
                // Note: basic date check ignoring exact time for the day
                .filter(f -> f.getDepartureTime().toLocalDate().equals(date.toLocalDate()))
                .collect(Collectors.toList());
    }
}
