

# Travel Agency System

## Overview
This project is designed as a backend system for a **Travel Agency** located in Cairo, focusing on core features that help users interact with hotel and event bookings, while providing a notification service for various actions like booking confirmations, password resets, and event reminders.

The system operates in two parts:
1. **Travel Agency System** running on **Port 8081**: Handles hotel bookings, event ticket reservations, user account management, and dashboard features.
2. **Notification System** running on **Port 8080**: Sends notifications such as booking confirmations, event reminders, and promotional offers to users.

## Features

### 1. **Hotel Room Booking**
   - Users can search and book hotel rooms of various types: Single, Double, or Family.
   - Users must create an account to proceed with the booking.
   - After booking a room, users will receive a confirmation notification via the Notification System.

### 2. **Event Ticket Booking**
   - Users can view and book tickets for local events happening in Cairo.
   - Event details are fetched from an external events API.
   - Notifications will be sent to users upon booking an event.

### 3. **User Dashboard**
   - Users can view and print all their bookings (hotel and event) from the dashboard.
   - Users will receive recommendations for events in the same location as their hotel booking during their stay.

### 4. **Event Recommendations**
   - After a hotel booking, users will be recommended events happening in the destination city within the same time frame of their stay.

### 5. **Notification System**
   - The notification system provides updates to users about their bookings and other relevant activities.
   - Notifications include event reminders, booking confirmations, and promotional offers.
   - Notifications are sent through various channels like email and SMS.

### 6. **Backend Communication**
   - The backend communicates with hotel providers and the events API to fetch real-time data and fulfill booking requests.
   - All requests and responses are handled via RESTful APIs.

### 7. **Notification Module**
   - The notification module handles templates for various notification types (confirmation emails, booking SMS, etc.).
   - Notifications are queued and sent asynchronously, avoiding delays for the end user.
   - The system keeps track of successfully and unsuccessfully sent notifications.

### 8. **Statistics & Reporting**
   - The system tracks notification statistics such as the number of successfully sent notifications, failure reasons, and most requested templates.
   
---

## System Architecture

The system follows a modular architecture with clear separation of concerns between the Travel Agency and Notification services:

1. **Travel Agency API (Port 8081)**
   - Handles requests related to hotel bookings, event bookings, user accounts, and event recommendations.
   
2. **Notification API (Port 8080)**
   - Handles notification sending, template management, queuing, and sending of notifications to users.

### Key Classes & Controllers:
- **ReceiverController** (Notification System): Handles incoming requests for sending notifications.
- **HotelController** (Travel Agency System): Manages hotel bookings and event tickets.
- **NotificationService** (Notification System): Handles sending notifications, template management, and queuing.
  
---

## Setup & Installation

### Prerequisites
Ensure that you have the following installed:
- **Java 11** or higher
- **Maven** (for building the project)
- **Postman** (for testing the APIs)

### Steps to Run the Project:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-repo/travel-agency.git
   cd travel-agency
   ```

2. **Set up the Travel Agency System:**
   - Navigate to the `travelagency` directory.
   - Build and run the application on port **8081**:
     ```bash
     mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
     ```

3. **Set up the Notification System:**
   - Navigate to the `notification-system` directory.
   - Build and run the application on port **8080**:
     ```bash
     mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8080"
     ```

4. **Access the APIs**:
   - The Travel Agency API will be accessible on:  
     `http://localhost:8081`
   - The Notification API will be accessible on:  
     `http://localhost:8080`

---

## API Endpoints

### **Travel Agency API (Port 8081)**

- **Book Hotel Room**  
  **URL:** `/api/hotel/bookRoom/{hotelId}/{roomType}`  
  **Method:** `POST`  
  **Parameters:**
  - `hotelId`: ID of the hotel.
  - `roomType`: Type of room (e.g., Single, Double, Family).  

- **Book Event Ticket**  
  **URL:** `/api/event/bookTicket/{eventId}`  
  **Method:** `POST`  
  **Parameters:**
  - `eventId`: ID of the event to be booked.

- **User Dashboard**  
  **URL:** `/api/dashboard`  
  **Method:** `GET`  
  **Returns:** A list of all bookings made by the user.

### **Notification API (Port 8080)**

- **Send Notification**  
  **URL:** `/api/notification/send-notification`  
  **Method:** `GET`  
  **Parameters:**
  - `message`: The message content to be sent as a notification.

---

## Testing

To test the APIs, use **Postman** or any API testing tool:

1. **Testing Hotel Booking:**
   - **Method:** `POST`
   - **URL:** `http://localhost:8081/api/hotel/bookRoom/{hotelId}/{roomType}`
   
2. **Testing Event Booking:**
   - **Method:** `POST`
   - **URL:** `http://localhost:8081/api/event/bookTicket/{eventId}`
   
3. **Testing Notification:**
   - **Method:** `GET`
   - **URL:** `http://localhost:8080/api/notification/send-notification?message=Booking%20confirmed%20for%20event%20XYZ`

---

## Future Enhancements

1. **User Authentication & Authorization**: Implement JWT-based authentication for secure access to the system.
2. **Database Integration**: Store user bookings, hotel details, and event information in a relational database (e.g., MySQL or PostgreSQL).
3. **Event API Integration**: Fetch event details from a live external event API (e.g., Eventbrite).
4. **More Notification Channels**: Expand notifications to include push notifications or other communication channels.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

