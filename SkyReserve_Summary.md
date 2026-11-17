# Smart Airline Reservation System (SkyReserve) - Project Summary

## 1. Project Overview
**Project Name**: SkyReserve
**Group ID**: `com.skyreserve`
**Version**: `1.0-SNAPSHOT`
**Language**: Java (JDK 17+)
**Build Tool**: Maven

**SkyReserve** is a modern, realistic Airline Reservation and Travel Management System built as a desktop application. Designed to look and feel like a professional travel platform (unlike a basic college project), it features a premium graphical user interface, robust architecture, and a comprehensive booking flow.

## 2. Technology Stack & Dependencies
The project leverages modern Java libraries to ensure a high-quality UI and robust architecture:
- **Core Java**: Java 17+
- **UI Framework**: Java Swing
- **Look and Feel**: [FlatLaf](https://www.formdev.com/flatlaf/) (v3.2.5) with `FlatLightLaf` - Delivers a sleek, modern UI with custom typography (Segoe UI/Inter) and a refined color palette (Deep Blue accents).
- **Layout Management**: [MigLayout](http://www.miglayout.com/) (v11.3) - Facilitates complex, responsive panel layouts.
- **Data Visualization**: [XChart](https://knowm.org/open-source/xchart/) (v3.8.7) - Powers administrative analytics dashboards.
- **Date Picker**: LGoodDatePicker (v11.2.1) - For modern calendar controls in flight search.

## 3. System Architecture & Design
The architecture is structured to support future database integration (e.g., MySQL via JDBC) while currently operating on in-memory repositories for prototyping.

### Repositories (`com.skyreserve.repositories`)
Simulates database persistence with mock data:
- `InMemoryBookingRepository`: Manages booking transactions.
- `InMemoryFlightRepository`: Handles flight schedules and availability.
- `InMemoryUserRepository`: Manages authentication for customers and admins.

### Models (`com.skyreserve.models`)
The core domain entities of the application:
- `Airline`, `Airport`, `Flight`, `Seat`
- `User`, `Passenger`, `Booking`

### Core Application & UI Components
- **`SkyReserveApplication.java`**: The main entry point. Initializes the `FlatLaf` design system and launches the GUI.
- **`MainFrame.java` & `AppShell.java`**: The primary application container that handles routing between different panels.
- **`AppSidebar.java` & `AppHeader.java`**: Navigation components ensuring a cohesive user experience.
- **`DesignToken.java`**: Centralized configuration for UI styling (colors, padding, fonts) to ensure consistency.

## 4. Key Modules & Workflows

### Customer Booking Flow (`com.skyreserve.ui.panels.customer`)
A comprehensive, multi-step process for customers:
1. **`FlightSearchForm`**: Intuitive search interface with origin, destination, and date selection.
2. **`FlightResultsPanel`**: Displays available flights, integrating a **`FareOptimizerPanel`** for pricing transparency.
3. **`SeatSelectionPanel`**: Interactive UI for picking specific seats on the aircraft.
4. **`PassengerDetailsPanel`**: Form for capturing traveler information.
5. **`PaymentPanel`**: Secure checkout simulation.
6. **`ConfirmationPanel`**: Final booking itinerary and ticket generation.

### Customer Dashboard
- **`CustomerDashboard`**: A personalized home screen for users.
- **`MyBookingsPanel`**: History of past and upcoming flights.
- **`FlightStatusBoard`**: Real-time mock updates on flight departures and arrivals.

### Admin Dashboard (`com.skyreserve.ui.panels.admin`)
- **`AdminDashboard`**: Management console for airline staff.
- **`GenericDataTablePanel`**: Reusable data grid for managing flights, users, and bookings.

## 5. Execution Flow
1. The application starts via `SkyReserveApplication`.
2. The UI is initialized with custom Design Tokens (colors, rounded corners, fonts).
3. The user arrives at the `LoginPanel` and authenticates as either a Customer or an Admin.
4. Based on the role, the `MainFrame` loads the respective Dashboard (Admin or Customer) wrapped in the `AppShell`.
5. Users navigate through their specific workflows (e.g., the 6-step Customer Booking Flow).

---
*Note: This summary provides a technical and functional overview of the SkyReserve project, suitable for inclusion in a final report.*
