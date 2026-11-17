package com.skyreserve.ui.panels.customer;

import com.skyreserve.models.Booking;
import com.skyreserve.models.Flight;
import com.skyreserve.models.Passenger;
import com.skyreserve.models.Seat;
import com.skyreserve.models.User;
import com.skyreserve.ui.components.DesignToken;

import javax.swing.*;
import java.awt.*;

public class CustomerBookingFlow extends JPanel {
    
    private final CardLayout cardLayout;
    private final JPanel container;
    private Booking currentBooking;
    private final User currentUser;

    public CustomerBookingFlow(User currentUser) {
        this.currentUser = currentUser;
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);
        
        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);
        container.setBackground(DesignToken.COLOR_BACKGROUND);
        
        // 1. Flight Results
        FlightResultsPanel resultsPanel = new FlightResultsPanel(this::onFlightSelected);
        container.add(resultsPanel, "RESULTS");
        
        add(container, BorderLayout.CENTER);
        cardLayout.show(container, "RESULTS");
    }
    
    private void onFlightSelected(Flight flight) {
        currentBooking = new Booking("PENDING", currentUser, flight);
        
        // 1.5 Fare Optimizer (USP #2)
        FareOptimizerPanel optimizerPanel = new FareOptimizerPanel(flight, optimizedFlight -> {
            currentBooking.setFlight(optimizedFlight);
            
            // 2. Seat Selection
            SeatSelectionPanel seatPanel = new SeatSelectionPanel(this::onSeatSelected);
            container.add(seatPanel, "SEAT");
            cardLayout.show(container, "SEAT");
        });
        
        container.add(optimizerPanel, "OPTIMIZER");
        cardLayout.show(container, "OPTIMIZER");
    }
    
    private void onSeatSelected(Seat seat) {
        // Prepare passenger (we will bind seat to passenger in the next step or later, but here we keep context simple)
        // 3. Passenger Details
        PassengerDetailsPanel passengerPanel = new PassengerDetailsPanel(p -> {
            p.setSelectedSeat(seat); // Bind the seat they chose
            currentBooking.getPassengers().clear();
            currentBooking.addPassenger(p);
            
            // 4. Payment (combines Summary in UI)
            PaymentPanel paymentPanel = new PaymentPanel(currentBooking, this::onPaymentSuccess);
            container.add(paymentPanel, "PAYMENT");
            cardLayout.show(container, "PAYMENT");
        });
        container.add(passengerPanel, "PASSENGER");
        cardLayout.show(container, "PASSENGER");
    }
    
    private void onPaymentSuccess(Booking booking) {
        // 5. Confirmation
        ConfirmationPanel confirmPanel = new ConfirmationPanel(booking, () -> {
            currentBooking = null; // Reset flow
            cardLayout.show(container, "RESULTS");
        });
        container.add(confirmPanel, "CONFIRM");
        cardLayout.show(container, "CONFIRM");
    }
}
