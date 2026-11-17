You are the LEAD SOFTWARE ARCHITECT, SENIOR JAVA SWING ENGINEER,
SENIOR DESKTOP UI/UX DESIGNER, PRODUCT DESIGNER, INTERACTION
DESIGNER and QA ENGINEER for this project.

We are starting this project completely from scratch.

================================================================
PROJECT
================================================================

PROJECT NAME:

SMART AIRLINE RESERVATION SYSTEM

PRODUCT / BRAND NAME:

SkyReserve

TAGLINE:

Travel Smarter. Fly Better.

The application is a modern Airline Reservation and Travel
Management System.

This is NOT a basic:

Search Flight → Book → Cancel

college project.

The goal is to create a polished, realistic airline reservation
desktop application that feels like a professional travel
reservation platform.

The final GUI must look COMPLETE.

A faculty member or Head of Department should be able to open the
application and navigate through the entire system without finding
unfinished sections, missing tabs, blank pages, dead buttons, or
fake controls.

================================================================
DEVELOPMENT ENVIRONMENT
================================================================

Development environment:

ANTIGRAVITY

AI MODEL:

GEMINI 3.1 PRO HIGH

Do NOT assume IntelliJ IDEA.

Antigravity is the development environment.

================================================================
TECHNOLOGY
================================================================

Use:

- Java 17+
- Java Swing
- Maven
- FlatLaf
- MigLayout where appropriate
- XChart or another stable Java charting library

Current GUI phase:

Use realistic in-memory repositories / mock repositories and
realistic sample data.

The current GUI must NOT depend on MySQL in order to work.

The architecture must be ready for later:

UI
↓
Service
↓
DAO
↓
JDBC
↓
MySQL

Do NOT build:

- React
- HTML/CSS
- JavaScript
- Electron
- JavaFX
- browser-based application
- web frontend

This must remain a NATIVE JAVA SWING DESKTOP APPLICATION.

================================================================
CURRENT PRIMARY OBJECTIVE
================================================================

Build a:

COMPLETE
FUNCTIONAL
RESPONSIVE
PROFESSIONAL
FULLY NAVIGABLE

AIRLINE RESERVATION SYSTEM GUI.

The application should visually appear almost ready for final
demonstration, even though deeper database persistence can be
implemented later.

The user must be able to navigate through the complete application.

Every major screen must have meaningful content.

Every important button must work.

Every tab must work.

Every dialog must work.

Every form must work.

Search must work.

Filters must work.

Seat selection must work.

Booking flow must work.

Fare calculations must work.

Smart recommendation must work.

Fare optimization must work.

Ticket generation must work.

Flight status must work.

Analytics must work.

================================================================
CRITICAL REQUIREMENT — DO NOT REPEAT PREVIOUS PROJECT PROBLEMS
================================================================

Previous generated projects suffered from:

- missing screens
- missing tabs
- buttons that did nothing
- unfinished dialogs
- dead navigation
- empty panels
- placeholder content
- fake charts
- broken interactions
- poor resizing
- incomplete workflows

DO NOT REPEAT THESE PROBLEMS.

A screen does NOT count as implemented merely because:

- a Java class exists
- a sidebar label exists
- a tab label exists
- a button exists
- a placeholder panel was created

A feature counts as COMPLETE only when it has been implemented,
wired to the application, populated with realistic data, and tested.

================================================================
PROJECT COMPLETENESS RULE
================================================================

THE PROJECT IS NOT COMPLETE WHEN THE SOURCE CODE IS GENERATED.

THE PROJECT IS COMPLETE ONLY AFTER:

1. The application is built.
2. The application is launched.
3. Every major navigation item is opened.
4. Every tab/sub-tab is clicked.
5. Every major button is tested.
6. Every important dialog is opened and tested.
7. Every form is tested.
8. Search is tested.
9. Filters are tested.
10. Sorting is tested where applicable.
11. Charts are tested.
12. Flight search is tested.
13. Smart recommendations are tested.
14. Fare optimizer is tested.
15. Seat selection is tested.
16. Passenger flow is tested.
17. Add-ons are tested.
18. Booking is tested.
19. Cancellation is tested.
20. Ticket generation is tested.
21. Flight status is tested.
22. Admin workflows are tested.
23. Resizing is tested.
24. All bugs discovered are FIXED.
25. Fixed features are RE-TESTED.
26. Only then should the project be considered complete.

================================================================
VISUAL DESIGN REFERENCE
================================================================

An airline UI reference image will be attached.

Use the attached image as the PRIMARY VISUAL REFERENCE.

The selected style is:

PREMIUM MODERN AIRLINE / TRAVEL PLATFORM

NOT GLASSMORPHISM.

Use:

- clean white/light workspace
- deep navy sidebar
- blue / sky-blue primary accent
- subtle cyan accents
- modern rounded cards
- soft shadows
- elegant spacing
- large origin/destination typography
- airline-style flight timelines
- premium seat map
- modern tables
- clean charts
- strong pricing hierarchy
- modern aviation imagery
- clean status badges
- professional travel dashboard aesthetic

The visual style should feel:

Premium
Modern
Trustworthy
Fast
Travel-focused
Professional
Data-driven

DO NOT use:

- glassmorphism
- excessive neon
- gaming UI
- excessive gradients
- childish colors
- excessive animations
- clutter

Every screen must use one unified design system.

================================================================
RESPONSIVE DESKTOP UI
================================================================

The Java Swing UI MUST resize correctly.

Test:

- maximized window
- medium window
- smaller desktop window
- different desktop resolutions
- high-DPI displays

STRICTLY DO NOT USE:

setLayout(null)

STRICTLY DO NOT USE:

setBounds()

for normal application layout.

Do not use absolute coordinates for the main UI.

Use:

- BorderLayout
- GridBagLayout
- CardLayout
- BoxLayout
- FlowLayout
- MigLayout

where appropriate.

Requirements:

NO overlapping controls.

NO clipped text.

NO missing buttons.

NO controls outside the window.

NO broken tables.

NO broken charts.

NO broken seat map.

NO oversized dialogs.

NO unusable filters.

NO massive empty spaces.

================================================================
APPLICATION SHELL
================================================================

Use one primary JFrame:

MainFrame

Structure:

MainFrame
│
├── Sidebar
├── Header
└── Content Area

Use CardLayout or another robust navigation system.

Do NOT create a new JFrame for every screen.

Use JDialog for focused tasks.

The application must feel like one unified airline software
platform.

================================================================
APPLICATION ROLES
================================================================

Support:

CUSTOMER
AIRLINE STAFF
ADMIN

CUSTOMER:

- Search Flights
- Book Flight
- Manage Booking
- My Bookings
- Flight Status
- Smart Recommendations
- Fare Optimizer
- Loyalty
- Profile
- Notifications
- Settings

AIRLINE STAFF:

- Dashboard
- Flights
- Passengers
- Bookings
- Check-in / Passenger Management
- Flight Status
- Revenue
- Reports
- Notifications

ADMIN:

Full access.

Role-based navigation must actually work.

================================================================
CUSTOMER NAVIGATION
================================================================

Customer sidebar:

HOME
- Customer Dashboard

TRAVEL
- Search & Book
- My Bookings
- Manage Booking
- Flight Status

SMART TRAVEL
- Smart Recommendations
- Fare & Travel Optimizer

ACCOUNT
- Loyalty Program
- Profile
- Notifications
- Settings

Logout

Every item must open a REAL implemented screen.

================================================================
ADMIN / STAFF NAVIGATION
================================================================

Admin/Staff sidebar:

OVERVIEW
- Dashboard

FLIGHTS
- Flights
- Flight Status
- Routes

PASSENGERS
- Passengers
- Check-in / Passenger Management

RESERVATIONS
- Bookings
- Seat Management
- Cancellations / Refunds

REVENUE
- Payments
- Revenue Analytics

INTELLIGENCE
- Smart Analytics
- Reports

SYSTEM
- Notifications
- Users
- Settings

Logout

Every item must lead to a real screen.

================================================================
LOGIN SCREEN
================================================================

Create a premium airline login interface.

Brand:

SkyReserve

Subtitle:

Smart Airline Reservation & Travel Management System

Include:

- logo
- aviation/travel visual
- username
- password
- show/hide password
- remember me
- forgot password
- login button

Optional role/demo options:

Login as Customer
Login as Staff
Login as Admin

Prototype credentials may be used.

Login must work.

Invalid login:

→ validation message

Valid login:

→ appropriate role-based application shell

Do not simply print login results to console.

================================================================
CUSTOMER DASHBOARD
================================================================

The Customer Dashboard must look like a real travel application.

Include:

WELCOME SECTION

Upcoming Trip

Example:

Delhi → Mumbai
20 Sep 2026
6E-204

06:30 AM → 08:40 AM

Seat 12A

Confirmed

[View Booking]

Other sections:

- Search Flights
- Upcoming Trips
- Recent Bookings
- SkyPoints
- Smart Deals
- Recommended Flights
- Notifications

Do not leave the dashboard mostly empty.

Populate it with realistic sample data.

================================================================
FLIGHT SEARCH
================================================================

Create a complete Flight Search screen.

Search modes:

- One Way
- Round Trip
- Multi City

Fields:

From
To
Departure
Return
Passengers
Class

Passenger types:

- Adults
- Children
- Infants

Class:

- Economy
- Premium Economy
- Business
- First

Button:

Search Flights

Search must actually filter the available sample flights.

================================================================
FLIGHT SEARCH VALIDATION
================================================================

Validate:

- origin required
- destination required
- origin != destination
- date required
- return date valid for round trip
- passenger count valid
- class selected

Show proper inline/form feedback.

================================================================
FLIGHT RESULTS
================================================================

This must be one of the most polished screens.

After search:

Show matching flights.

Each flight card:

Airline
Flight Number
Departure
Arrival
Duration
Stops
Baggage
Price
Seat Availability
Match Score where applicable

Example:

IndiGo
6E-204

06:30
DEL

08:40
BOM

2h 10m

Non-stop

₹5,240

[Select]

Second:

Air India
AI-865

09:15
DEL

11:45
BOM

2h 30m

₹5,650

[Select]

================================================================
FLIGHT RESULT FILTERS
================================================================

Filters:

- Price Range
- Airlines
- Stops
- Departure Time
- Arrival Time
- Baggage
- Class
- Duration

Sorting:

- Recommended
- Cheapest
- Fastest
- Earliest Departure
- Latest Departure

Every filter must actually change results.

Reset Filters must restore original results.

================================================================
USP #1
SMART FLIGHT RECOMMENDATION ENGINE
================================================================

This is a PRIMARY USP.

Create:

SMART FLIGHT RECOMMENDATIONS

The system analyzes:

- price
- duration
- stops
- departure time
- arrival time
- baggage
- seat availability
- customer preferences
- airline preference
- travel class preference

Then calculate:

MATCH SCORE

0–100

Example:

IndiGo 6E-204

Match Score:
95%

Best Overall

Reasons:

✓ Lowest price
✓ Non-stop
✓ Good departure time
✓ High seat availability

Another flight:

Air India AI-865

Match Score:
88%

Reasons:

✓ Better departure time
✓ Extra baggage
✗ Higher price

Scores MUST be calculated.

DO NOT hardcode 95%.

================================================================
MATCH SCORE BREAKDOWN
================================================================

When user clicks:

View Match Details

show:

Price Fit
Duration Fit
Timing Fit
Stop Preference
Baggage Fit
Availability
Airline Preference

Example:

Overall:
92%

Price:
95%

Duration:
88%

Timing:
90%

Baggage:
100%

Provide an explanation:

"Recommended because it offers the best combination of price,
duration and departure time for your selected preferences."

================================================================
USP #2
SMART FARE & TRAVEL OPTIMIZER
================================================================

This is the second PRIMARY USP.

Create:

SMART FARE & TRAVEL OPTIMIZER

Given a selected flight, analyze alternatives.

Examples:

Current Selection
₹7,420

Alternative Flight
₹6,180
Save ₹1,240

Flexible departure
₹5,940
Save ₹1,480

Round-trip combination
Save ₹1,820

The optimizer should evaluate:

- alternate flights
- alternate departure times
- alternate return dates
- round-trip combinations
- different airlines
- nearby airports where appropriate in the sample model
- add-on combinations

DO NOT hardcode savings.

Create:

FareOptimizationService

Return:

OptimizationResult

containing:

- original option
- alternative
- original price
- alternative price
- savings
- explanation

================================================================
FARE OPTIMIZER SCREEN
================================================================

Show:

CURRENT SELECTION

IndiGo 6E-204
₹7,420

Potential Savings:

₹1,480

OPTIONS:

Cheaper Flight
₹6,180
Save ₹1,240

Flexible Departure
₹5,940
Save ₹1,480

Round Trip Combination
₹11,420
Save ₹1,820

Buttons:

View Flight
Select
Compare

When user selects an alternative:

→ selected flight changes
→ price updates
→ summary updates
→ continue booking

================================================================
FLIGHT COMPARISON
================================================================

Create comparison view.

Compare 2–3 flights.

Columns:

Price
Duration
Stops
Departure
Arrival
Baggage
Seats
Match Score

Highlight:

Best Price
Fastest
Best Overall

Do not simply display static labels.

Calculate them.

================================================================
FLIGHT DETAILS
================================================================

Flight detail screen:

Airline
Flight Number
Aircraft
Departure Airport
Arrival Airport
Departure Time
Arrival Time
Duration
Stops
Baggage
Fare Rules
Available Seats

Tabs:

Overview
Fare Rules
Baggage
Amenities
Reviews/Rating if sample data supports it

EVERY TAB MUST WORK.

No empty tabs.

================================================================
SEAT SELECTION
================================================================

Create an elegant interactive aircraft seat map.

Include:

- seat rows
- columns
- aisle
- available seats
- selected seat
- occupied seats
- extra-legroom seats

Legend:

Available
Selected
Occupied
Extra Legroom

Click seat:

Show:

Seat 12A

Window
Economy
₹500

[Confirm Seat]

Selecting a seat must update booking data.

Occupied seats must not be selectable.

================================================================
SEAT SELECTION VALIDATION
================================================================

User cannot continue unless required seat selection is complete.

If selected seat is unavailable:

show proper error.

If seat changes:

old seat becomes available
new seat becomes selected

================================================================
PASSENGER DETAILS
================================================================

Create passenger entry screen.

Fields:

Title
Full Name
Age
Gender
Nationality
ID Type
ID Number
Phone
Email

For multiple passengers:

Add Passenger
Edit Passenger
Remove Passenger

Validate required fields.

Passenger information must persist through the booking workflow.

================================================================
ADD-ONS
================================================================

Allow:

- extra baggage
- meal
- priority boarding
- travel insurance where appropriate
- seat upgrade where practical

Example:

Extra baggage 5kg
₹800

Vegetarian Meal
₹350

Priority Boarding
₹500

Each selection must update total fare.

================================================================
MEAL SELECTION
================================================================

Meals:

- Standard
- Vegetarian
- Vegan
- Jain
- Non-Vegetarian

Meal selection must be connected to the passenger/booking.

================================================================
BAGGAGE
================================================================

Display:

Cabin baggage
Check-in baggage
Extra baggage

If user chooses extra baggage:

→ add charge to booking summary.

================================================================
BOOKING SUMMARY
================================================================

Create a final review page.

Show:

Flight
Date
Route
Passengers
Seats
Baggage
Meals
Add-ons

Fare:

Base Fare
Seat Charges
Baggage
Meals
Other Add-ons
Taxes
Discount
Total

All calculations must be dynamic.

================================================================
PAYMENT
================================================================

Payment methods:

- UPI
- Card
- Cash/Offline where appropriate for staff simulation

This is a simulated payment.

Do NOT connect to a real payment gateway.

Payment UI must change according to selected method.

For UPI:

Reference field

For card:

simulation fields

After successful payment:

→ booking created
→ PNR generated
→ ticket generated

================================================================
BOOKING CONFIRMATION
================================================================

Create a premium confirmation screen.

Show:

✓ Booking Confirmed

PNR:
AX7K92

DEL → BOM

Flight:
6E-204

Passenger:
Sarthak Jain

Seat:
12A

Departure:
06:30 AM

Arrival:
08:40 AM

Total:
₹11,980

Buttons:

Download Ticket
Print Ticket
View Booking
Send Email simulation

================================================================
E-TICKET
================================================================

Create an airline-style digital ticket.

Include:

SkyReserve
PNR
Passenger
Route
Flight
Date
Departure
Arrival
Seat
Class
Baggage
Gate
Boarding Time
QR/Barcode-style visual

The ticket should look polished.

It should be generated from booking data.

Do not create a static unrelated ticket.

================================================================
MANAGE BOOKING
================================================================

Customer enters:

PNR
Passenger Name

Then retrieve the actual sample booking.

Show:

- itinerary
- passenger
- seat
- baggage
- meal
- payment
- status

Actions:

Modify
Cancel
View Ticket

Search must actually work.

================================================================
MY BOOKINGS
================================================================

Table/cards:

PNR
Route
Date
Flight
Passenger
Seat
Amount
Status

Statuses:

Confirmed
Completed
Cancelled
Pending

Actions:

View
Modify
Cancel
Ticket

================================================================
BOOKING MODIFICATION
================================================================

Allow modification where appropriate.

Examples:

- seat
- baggage
- meal
- passenger details where permitted

Changes must update booking summary.

================================================================
CANCELLATION & REFUND
================================================================

Create:

CANCEL BOOKING

Show:

Booking amount
Cancellation fee
Refund amount

Example:

Booking:
₹7,420

Cancellation Fee:
₹390

Refund:
₹7,030

These values must be calculated according to configurable
prototype rules.

After cancellation:

Booking status
→ Cancelled

Refund status
→ Processed/Pending

================================================================
FLIGHT STATUS
================================================================

Create:

FLIGHT STATUS BOARD

Modes:

Departures
Arrivals

Filters:

Airport
Date
Status

Statuses:

Scheduled
Check-in Open
Boarding
Delayed
Departed
Cancelled
Landed

Table:

Flight
Destination
Scheduled
Actual
Gate
Status

Status indicators must be visually clear.

Click flight:

→ Flight details.

================================================================
CUSTOMER LOYALTY
================================================================

Create:

SKYPOINTS / LOYALTY

Show:

Current Points
Tier
Points Earned
Points Redeemed
Next Tier

Example:

Gold Member
8,420 points

This Booking:
+520

Create useful but simple loyalty functionality.

================================================================
ADMIN DASHBOARD
================================================================

Create a separate admin/staff dashboard.

KPIs:

Today's Flights
Bookings
Passengers
Revenue
Cancellations
Average Occupancy

Charts:

- Booking Trend
- Revenue Trend
- Route Popularity
- Flight Occupancy
- Passenger Distribution
- Cancellation Trend

Additional sections:

Recent Bookings
Flight Alerts
Upcoming Departures
Revenue Summary
Smart Insights

All must use sample data.

================================================================
FLIGHT MANAGEMENT
================================================================

Admin can view/manage flights.

Table:

Flight Number
Airline
Origin
Destination
Date
Departure
Arrival
Aircraft
Capacity
Booked
Available
Status

Features:

Search
Filter
Sort
Add
Edit
Delete
View

================================================================
ROUTE MANAGEMENT
================================================================

Manage:

Origin
Destination
Distance
Duration
Flight Count
Popularity

Features:

Add
Edit
Delete
Search
Filter

================================================================
PASSENGER MANAGEMENT
================================================================

Admin/staff passenger table.

Columns:

Passenger ID
Name
Booking/PNR
Flight
Seat
Class
Status
Actions

Search and filter must work.

================================================================
CHECK-IN / PASSENGER MANAGEMENT
================================================================

For staff:

Search booking/PNR.

Display passenger.

Allow simulated check-in.

Statuses:

Not Checked In
Checked In
Boarding
Boarded

Update booking/passenger state.

================================================================
SEAT MANAGEMENT
================================================================

Admin/staff can inspect:

- occupied
- available
- blocked
- extra legroom

Visual seat map.

Changes must reflect appropriately in sample data.

================================================================
REVENUE
================================================================

Create revenue module.

Show:

Daily Revenue
Monthly Revenue
Average Fare
Add-on Revenue
Refunds
Net Revenue

Charts:

Revenue Trend
Revenue by Route
Revenue by Cabin
Add-on Revenue

================================================================
ANALYTICS
================================================================

Create dedicated analytics dashboard.

Sections:

Flight Analytics
Booking Analytics
Passenger Analytics
Revenue Analytics
Route Analytics
Cancellation Analytics

Charts:

- Bookings by month
- Revenue by month
- Popular routes
- Occupancy rate
- Cancellation rate
- Cabin distribution
- Passenger volume
- Average booking value

Filters:

- date range
- route
- flight
- cabin
- airline

Charts MUST update based on filters.

================================================================
SMART INSIGHTS
================================================================

Create data-driven insights.

Examples:

"DEL → BOM is the most booked route this month."

"Evening flights currently have the highest occupancy."

"Business-class bookings increased 12%."

"Flight 6E-204 is 92% occupied."

"Cancellation rate increased this week."

Insights must come from the sample data.

Do not hardcode unrelated statements.

================================================================
NOTIFICATIONS
================================================================

Types:

- Flight Reminder
- Check-in Open
- Gate Change
- Delay
- Cancellation
- Payment Success
- Booking Confirmation
- Fare Alert
- Refund Update

Features:

Mark Read
Mark All Read
Filter
Clear

Unread count must update.

================================================================
REPORTS
================================================================

Create Reports module.

Reports:

- Booking Report
- Passenger Report
- Flight Report
- Revenue Report
- Route Report
- Cancellation Report
- Occupancy Report
- Loyalty Report

Filters:

- Date
- Flight
- Route
- Cabin
- Status

Actions:

Generate
Preview
Export

Reports should actually use the current sample data.

================================================================
SETTINGS
================================================================

Settings:

Profile
Preferences
Security
Notifications
Application Info

Security:

Change Password

Preferences:

Theme
Notifications
Default airport
Default cabin

================================================================
DIALOG SYSTEM
================================================================

Create professional reusable dialogs.

Required:

- Add Flight
- Edit Flight
- Delete Flight
- Add Route
- Edit Route
- Delete Route
- Passenger Dialog
- Booking Dialog
- Seat Selection Dialog where appropriate
- Add-on Dialog
- Payment Dialog
- Cancellation Dialog
- Refund Dialog
- Change Password
- Confirmation
- Success
- Error
- Warning
- Information

Dialogs must:

- open correctly
- be centered
- have correct size
- contain all fields
- validate fields
- have correct actions
- preserve existing context
- close correctly

Do not rely on default JOptionPane for everything.

================================================================
GLOBAL SEARCH
================================================================

Header search should search across:

Flights
PNRs
Passengers
Bookings
Routes

Results must be clickable.

Clicking a result should navigate to the correct module.

================================================================
TABLE REQUIREMENTS
================================================================

Tables should support where appropriate:

- sorting
- searching
- filtering
- scrolling
- row selection
- actions
- refresh
- pagination

Use sensible column widths.

Do not create unreadable tables.

================================================================
MOCK DATA
================================================================

Create realistic internally consistent sample data.

Include:

- multiple airports
- multiple airlines
- multiple flights
- multiple routes
- passengers
- bookings
- seat occupancy
- baggage
- meals
- add-ons
- payments
- cancellations
- refunds
- loyalty accounts
- notifications

Data relationships MUST be consistent.

Examples:

A booking references an existing flight.

A passenger belongs to an existing booking.

A seat cannot simultaneously be occupied by two passengers.

A selected flight must have available seats.

Cancelled booking cannot remain displayed as confirmed.

Payment total must match booking total.

Refund must correspond to cancelled booking.

================================================================
REPOSITORY ARCHITECTURE
================================================================

Create interfaces such as:

FlightRepository
AirportRepository
RouteRepository
PassengerRepository
BookingRepository
SeatRepository
PaymentRepository
LoyaltyRepository
NotificationRepository

In-memory implementations:

InMemoryFlightRepository
InMemoryBookingRepository
etc.

UI must NOT directly manipulate random lists.

Use:

UI
↓
Service
↓
Repository

Later:

UI
↓
Service
↓
DAO
↓
JDBC
↓
MySQL

================================================================
SERVICE LAYER
================================================================

Create appropriate services:

AuthenticationService
FlightService
SearchService
BookingService
SeatService
PassengerService
PaymentService
FareService
RecommendationService
FareOptimizationService
LoyaltyService
CancellationService
RefundService
AnalyticsService
NotificationService
ReportService

Business logic must be inside services.

Do not place major business logic inside Swing panels.

================================================================
SMART RECOMMENDATION ENGINE
================================================================

Create:

RecommendationService

Inputs:

- search criteria
- available flights
- customer preferences

Possible score components:

Price Fit
Duration Fit
Timing Fit
Stops Fit
Baggage Fit
Availability
Airline Preference

Normalize:

0–100

Return:

RecommendationResult

containing:

- flight
- score
- reasons
- advantages
- disadvantages

================================================================
FARE OPTIMIZATION ENGINE
================================================================

Create:

FareOptimizationService

Given current selection:

Find:

- cheaper alternatives
- faster alternatives
- flexible-time alternatives
- round-trip savings
- relevant fare combinations

Return:

OptimizationResult

containing:

- current option
- alternative
- price difference
- savings
- reason

================================================================
FARE CALCULATION
================================================================

Create one centralized:

FareCalculationService

Calculate:

Base Fare
Seat Fare
Baggage
Meal
Add-ons
Taxes
Discount
Loyalty Discount
Final Total

Do NOT duplicate calculations in different panels.

================================================================
BOOKING ENGINE
================================================================

Create one centralized booking workflow.

Booking process:

Search
↓
Select Flight
↓
Recommendation / Optimization
↓
Seat
↓
Passenger
↓
Extras
↓
Summary
↓
Payment
↓
Booking
↓
PNR
↓
Ticket

Every stage must retain the selected booking context.

================================================================
UI STATE MANAGEMENT
================================================================

When user moves through booking steps:

Do NOT lose:

- selected flight
- selected date
- passengers
- seats
- baggage
- meals
- add-ons
- fare
- discounts

Use an appropriate booking session/state object.

================================================================
LOADING / EMPTY / ERROR / SUCCESS
================================================================

Every major screen must support:

Loading
Empty
Error
Success
No Search Results
No Filter Results

Examples:

"No flights found for your selected route."

"No bookings found."

"Unable to load flight information."

"Booking confirmed successfully."

Do not leave blank panels.

================================================================
DESIGN SYSTEM
================================================================

Create centralized design tokens:

Primary Blue
Secondary Blue
Navy
Background
Surface
Border
Text Primary
Text Secondary
Success
Warning
Error
Info

Also centralize:

- spacing
- typography
- corner radius
- shadows
- button sizes
- table style
- status badge style

Do not choose styling independently on each screen.

================================================================
SIDEBAR
================================================================

Sidebar must clearly separate:

Overview
Travel
Reservations
Intelligence
System

Use consistent icons.

Active item must be obvious.

Hover state required.

================================================================
HEADER
================================================================

Header:

- Global Search
- Notification icon
- User avatar
- User name
- Membership/role
- profile dropdown

Admin header can display:

Airport / Operating Day / Academic-like period not required.

Keep it clean.

================================================================
PAGE HEADER
================================================================

Every screen must have:

Page Title
Description
Breadcrumb where useful
Primary Action where relevant

Example:

Smart Recommendations

"Find the best flight options based on your preferences."

================================================================
NO DEAD TABS
================================================================

This is a HARD REQUIREMENT.

If a screen contains tabs, ALL tabs must contain real functionality.

Examples:

Flight Details:
Overview
Fare Rules
Baggage
Amenities

Customer Profile:
Overview
Bookings
Loyalty
Activity

Recommendations:
Recommended
Cheapest
Fastest
Personalized

Analytics:
Flights
Bookings
Passengers
Revenue

All tabs must be clickable and populated.

================================================================
MANDATORY TAB-BY-TAB QA
================================================================

After implementation, explicitly test EVERY tab.

For each tab:

1. Click tab.
2. Confirm correct content appears.
3. Confirm content isn't empty.
4. Confirm context is preserved.
5. Click relevant controls.
6. Test search/filter where applicable.
7. Test actions.
8. Test dialogs.
9. Test resizing.

If broken:

FIX IT.

Then RE-TEST.

Do not simply report the problem.

================================================================
MANDATORY SCREEN INVENTORY
================================================================

The following screens MUST exist:

CUSTOMER

1. Login
2. Customer Dashboard
3. Search & Book
4. Flight Results
5. Flight Details
6. Flight Comparison
7. Smart Recommendations
8. Fare & Travel Optimizer
9. Seat Selection
10. Passenger Details
11. Add-ons
12. Booking Summary
13. Payment
14. Booking Confirmation
15. E-Ticket
16. My Bookings
17. Manage Booking
18. Modify Booking
19. Cancellation / Refund
20. Flight Status
21. Loyalty
22. Profile
23. Notifications
24. Settings

ADMIN / STAFF

25. Admin Dashboard
26. Flights
27. Flight Details
28. Routes
29. Passengers
30. Check-in
31. Seat Management
32. Bookings
33. Payments
34. Revenue
35. Analytics
36. Reports
37. Notifications
38. Users
39. Settings
40. Change Password

SUPPORT:

41. Loading states
42. Empty states
43. Error states
44. Success states
45. Confirmation dialogs
46. Warning dialogs
47. Information dialogs

ALL MUST EXIST.

================================================================
NO MISSING WINDOWS
================================================================

Every action that logically requires a separate dialog/window must
have that window.

Examples:

Add Flight
Edit Flight
Delete Flight
Add Passenger
Seat Selection
Payment
Cancellation
Refund
Change Password
Booking Details
Ticket Details

Do not create a button that should open a dialog and instead do
nothing.

================================================================
SEARCH FLOW TEST
================================================================

Test:

Delhi → Mumbai

Search

Verify results.

Change date.

Verify results change.

Apply price filter.

Verify results change.

Apply airline filter.

Verify results change.

Reset filters.

Verify original results return.

================================================================
SMART RECOMMENDATION TEST
================================================================

Search for flight.

Verify recommended flights appear.

Verify score is calculated.

Click Match Details.

Verify:

- price analysis
- duration analysis
- timing analysis
- stops
- baggage
- availability

Select recommendation.

Verify selected flight becomes current booking option.

================================================================
FARE OPTIMIZER TEST
================================================================

Select flight.

Open Fare Optimizer.

Verify alternatives.

Verify savings calculations.

Select cheaper alternative.

Verify:

Flight changes
Price changes
Booking context remains valid

================================================================
SEAT TEST
================================================================

Select flight.

Open Seat Selection.

Click available seat.

Verify selection.

Click another seat.

Verify previous selection is released.

Click occupied seat.

Verify selection is denied.

Confirm.

Verify selected seat appears in Booking Summary.

================================================================
BOOKING TEST
================================================================

Complete:

Search
→ Select
→ Seat
→ Passenger
→ Add-ons
→ Summary
→ Payment
→ Confirmation

Verify:

- fare
- seat
- passenger
- add-ons
- PNR
- booking status

All values must match.

================================================================
CANCELLATION TEST
================================================================

Open booking.

Cancel.

Verify:

Cancellation fee
Refund
Booking status

After confirmation:

Booking becomes Cancelled.

It must not continue appearing as Confirmed.

================================================================
FLIGHT STATUS TEST
================================================================

Open status board.

Filter.

Open a flight.

Verify details.

Change a simulated status if admin role permits.

Verify display updates.

================================================================
ADMIN END-TO-END TEST
================================================================

Login as Admin.

Dashboard
→ Flights
→ Search
→ Add Flight
→ Edit Flight
→ Delete Flight
→ Routes
→ Passengers
→ Bookings
→ Payments
→ Revenue
→ Analytics
→ Reports
→ Notifications
→ Users
→ Settings
→ Logout

Every operation must work.

================================================================
DATA CONSISTENCY TEST
================================================================

Verify:

Flight exists
→ appears in search

Flight selected
→ seat availability updates

Seat selected
→ booking summary updates

Booking completed
→ My Bookings updates

Booking completed
→ analytics can update

Booking completed
→ revenue can update

Booking cancelled
→ seat becomes available

Booking cancelled
→ refund appears

Cancelled booking
→ no longer counted as confirmed

Everything must remain internally consistent.

================================================================
ANALYTICS TEST
================================================================

For every chart:

1. Load chart.
2. Confirm it renders.
3. Change filter.
4. Confirm chart data changes.
5. Reset filter.
6. Confirm original result.

Charts must use the data layer.

They must NOT be static screenshots.

================================================================
RESPONSIVE QA
================================================================

Run the application at:

1. Maximized
2. Medium window
3. Smaller desktop window

Test:

Dashboard
Flight Results
Seat Map
Passenger Form
Booking Summary
E-Ticket
Analytics
Reports
Dialogs

Fix all layout problems.

================================================================
VISUAL COMPLETENESS AUDIT
================================================================

Inspect EVERY screen.

No:

- blank panels
- placeholder text
- Coming Soon
- TODO
- unfinished sections
- broken images
- missing buttons
- missing headers
- missing descriptions
- inconsistent spacing
- inconsistent typography
- default ugly Swing styling
- empty tables where data should exist

Use realistic sample data so screens look populated.

================================================================
FINAL SCREEN MATRIX
================================================================

Create:

Screen
Navigation
Content
Tabs
Buttons
Dialogs
Data
States
Resize
PASS/FAIL

Every required screen must PASS.

================================================================
FINAL TAB MATRIX
================================================================

Create:

Screen
Tab
Content Exists
Interactive
Tested
PASS/FAIL

Every tab MUST PASS.

================================================================
FINAL BUTTON MATRIX
================================================================

Create:

Screen
Button
Expected Action
Actual Action
PASS/FAIL

Every important button MUST PASS.

================================================================
FINAL DIALOG MATRIX
================================================================

Create:

Dialog
Opens
Fields
Validation
Cancel
Confirm/Save
Feedback
PASS/FAIL

Every required dialog MUST PASS.

================================================================
FINAL END-TO-END CUSTOMER WALKTHROUGH
================================================================

Actually execute:

1. Login as Customer
2. Open Dashboard
3. Search Flight
4. Filter results
5. Open Flight Details
6. View Match Details
7. Open Smart Recommendations
8. Select Recommended Flight
9. Open Fare Optimizer
10. Compare alternatives
11. Select optimized option
12. Select seat
13. Enter passenger
14. Add baggage
15. Add meal
16. Review booking
17. Payment
18. Booking confirmation
19. View E-Ticket
20. Open My Bookings
21. Manage booking
22. Open Flight Status
23. Open Loyalty
24. Open Notifications
25. Open Settings
26. Logout

Every step must work.

================================================================
FINAL END-TO-END ADMIN WALKTHROUGH
================================================================

Actually execute:

1. Login as Admin
2. Dashboard
3. Flights
4. Search
5. Add Flight
6. Edit Flight
7. Delete Flight
8. Routes
9. Passengers
10. Check-in
11. Bookings
12. Payments
13. Revenue
14. Analytics
15. Change filters
16. Verify charts
17. Reports
18. Notifications
19. Users
20. Settings
21. Logout

Every step must work.

================================================================
PERFORMANCE
================================================================

Keep the Swing UI responsive.

Do not block the Event Dispatch Thread unnecessarily.

Use SwingWorker/background tasks where appropriate for:

- loading large datasets
- analytics
- report generation

================================================================
SECURITY PREPARATION
================================================================

Prototype authentication may use demo credentials.

But architect for:

- role-based access
- password hashing later
- safe database queries later
- PreparedStatement
- input validation

Do not spread authentication logic across random UI classes.

================================================================
FUTURE DATABASE COMPATIBILITY
================================================================

Do not tightly couple the UI to mock data.

Use repository/service interfaces so later we can implement:

MySQL + JDBC

without rewriting the complete GUI.

================================================================
CODE QUALITY
================================================================

Avoid:

- giant JFrame classes
- giant event handlers
- duplicated business logic
- duplicated styles
- magic numbers
- direct data manipulation from panels
- tightly coupled screens

Use reusable components.

================================================================
REUSABLE UI COMPONENTS
================================================================

Create reusable components:

AppSidebar
AppHeader
PageHeader
StatCard
FlightCard
FlightTimeline
StatusBadge
SearchField
FilterDropdown
StyledTable
SeatComponent
FareSummary
PriceLabel
OfferBadge
DialogBase
ChartCard
EmptyStatePanel
LoadingPanel
ErrorPanel

================================================================
FINAL HARD REQUIREMENT
================================================================

DO NOT STOP AFTER:

Login.

DO NOT STOP AFTER:

Dashboard.

DO NOT STOP AFTER:

Flight Search.

DO NOT STOP AFTER:

Flight Results.

DO NOT STOP AFTER:

Smart Recommendations.

DO NOT STOP AFTER:

Booking.

Continue until the COMPLETE application has been implemented.

================================================================
NO FAKE COMPLETION
================================================================

DO NOT SAY:

"All tabs are implemented"

unless every tab was actually checked.

DO NOT SAY:

"All buttons work"

unless they were tested.

DO NOT SAY:

"The UI is responsive"

unless resizing was tested.

DO NOT SAY:

"The project is complete"

unless the acceptance checklist passes.

================================================================
WHEN A PROBLEM IS FOUND
================================================================

If you find:

- missing screen
- broken tab
- broken button
- broken dialog
- incorrect navigation
- blank content
- incorrect calculation
- broken chart
- broken resizing
- runtime error

DO NOT merely report the issue.

FIX IT.

Run the affected flow again.

Then verify the fix.

================================================================
FINAL ACCEPTANCE CHECKLIST
================================================================

[ ] Application launches

[ ] Login works

[ ] Role selection works

[ ] Customer dashboard works

[ ] Admin dashboard works

[ ] Flight search works

[ ] Flight filters work

[ ] Flight sorting works

[ ] Flight details works

[ ] Flight comparison works

[ ] Smart Recommendations work

[ ] Match scores calculate

[ ] Fare Optimizer works

[ ] Savings calculate

[ ] Seat selection works

[ ] Occupied seats cannot be selected

[ ] Passenger details work

[ ] Multiple passengers work

[ ] Add-ons work

[ ] Baggage calculations work

[ ] Meal selection works

[ ] Fare calculation works

[ ] Payment works

[ ] Booking confirmation works

[ ] PNR generated

[ ] E-Ticket generated

[ ] My Bookings works

[ ] Manage Booking works

[ ] Booking modification works

[ ] Cancellation works

[ ] Refund calculation works

[ ] Flight Status works

[ ] Loyalty works

[ ] Notifications work

[ ] Admin flight management works

[ ] Route management works

[ ] Passenger management works

[ ] Check-in works

[ ] Seat management works

[ ] Payment management works

[ ] Revenue works

[ ] Analytics works

[ ] Charts render

[ ] Charts update with filters

[ ] Reports work

[ ] Settings work

[ ] Change Password works

[ ] Search works

[ ] Filters work

[ ] Sorting works

[ ] Add operations work

[ ] Edit operations work

[ ] Delete operations work

[ ] Every required tab works

[ ] Every required dialog works

[ ] Loading states exist

[ ] Empty states exist

[ ] Error states exist

[ ] Success states exist

[ ] No blank screens

[ ] No placeholder screens

[ ] No Coming Soon

[ ] No TODO placeholder

[ ] No dead buttons

[ ] No dead navigation

[ ] No fake charts

[ ] No fake calculations

[ ] No broken images

[ ] No clipped controls

[ ] No overlapping controls

[ ] Responsive resizing works

[ ] Customer end-to-end flow passes

[ ] Admin end-to-end flow passes

[ ] Data remains consistent

[ ] Application compiles

[ ] Application runs

[ ] Full QA audit completed

[ ] All discovered bugs fixed

[ ] All fixes re-tested

================================================================
FINAL QA REPORT
================================================================

After completing implementation and testing, provide a final QA
summary containing:

1. Number of screens implemented
2. Number of tabs/sub-tabs implemented
3. Number of dialogs implemented
4. Number of buttons/actions tested
5. Number of end-to-end workflows tested
6. Search/filter tests
7. Chart tests
8. Seat-selection tests
9. Booking tests
10. Cancellation/refund tests
11. Responsive tests
12. Bugs found
13. Bugs fixed
14. Remaining issues, if any

Do not hide remaining problems.

================================================================
FINAL ACCEPTANCE STANDARD
================================================================

The final application should look like:

A professional airline reservation and travel management
software product.

NOT:

A basic Java Swing college assignment.

It must be:

COMPLETE
FUNCTIONAL
RESPONSIVE
CONSISTENT
POLISHED
DATA-DRIVEN
EASY TO DEMONSTRATE

The two major USP features must be prominent and genuinely
functional:

USP #1:
SMART FLIGHT RECOMMENDATION ENGINE

USP #2:
SMART FARE & TRAVEL OPTIMIZER

================================================================
START
================================================================

Start by inspecting the workspace.

Create the project foundation.

Implement the design system.

Implement the application shell.

Implement ALL customer screens.

Implement ALL admin/staff screens.

Implement all dialogs.

Implement all tabs.

Implement all interactions.

Populate the application with realistic sample data.

Then:

RUN THE APPLICATION.

TEST EVERY SCREEN.

TEST EVERY TAB.

TEST EVERY BUTTON.

TEST EVERY DIALOG.

TEST EVERY SEARCH.

TEST EVERY FILTER.

TEST EVERY CHART.

TEST SMART RECOMMENDATIONS.

TEST FARE OPTIMIZATION.

TEST SEAT SELECTION.

TEST BOOKING.

TEST CANCELLATION.

TEST REFUND.

TEST FLIGHT STATUS.

TEST ADMIN FLOWS.

TEST RESPONSIVE RESIZING.

FIX ALL FAILURES.

RE-RUN.

RE-TEST.

Only after everything passes should you consider the GUI complete.

THE FINAL GUI MUST LOOK COMPLETE.

NOTHING SHOULD LOOK MISSING.
