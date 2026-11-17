package com.skyreserve.models;

public class Seat {
    private String seatNumber; // e.g. "12A"
    private boolean isAvailable;
    private boolean isExtraLegroom;
    private double price;

    public Seat(String seatNumber, boolean isAvailable, boolean isExtraLegroom, double price) {
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
        this.isExtraLegroom = isExtraLegroom;
        this.price = price;
    }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public boolean isExtraLegroom() { return isExtraLegroom; }
    public void setExtraLegroom(boolean extraLegroom) { isExtraLegroom = extraLegroom; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
