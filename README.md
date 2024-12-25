

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

#### 1. **Add Hotel**
   - **URL:** `/HotelController/addHotel`
   - **Method:** `POST`
   - **Description:** Adds a new hotel to the system.
   - **Request Body:**
     ```json
     {
       "name": "Hotel Name",
       "location": "Cairo",
       "rooms": [
         {
           "type": "Single",
           "price": 100
         },
         {
           "type": "Double",
           "price": 150
         }
       ]
     }
     ```
   - **Response:**
     - Success: `201 Created`
     - Failure: `400 Bad Request`
  
#### 2. **Get All Hotels**
   - **URL:** `/HotelController/getAll`
   - **Method:** `GET`
   - **Description:** Retrieves a list of all hotels.
   - **Response:**
     - Success: `200 OK` with a list of hotels.
     - Failure: `404 Not Found` if no hotels are available.

#### 3. **Update Hotel**
   - **URL:** `/HotelController/update/{id}`
   - **Method:** `PUT`
   - **Description:** Updates the details of a specific hotel.
   - **Path Parameter:**
     - `id`: The unique ID of the hotel to be updated.
   - **Request Body:**
     ```json
     {
       "name": "Updated Hotel Name",
       "location": "Updated Location",
       "rooms": [
         {
           "type": "Family",
           "price": 200
         }
       ]
     }
     ```
   - **Response:**
     - Success: `200 OK` with the updated hotel data.
     - Failure: `404 Not Found` if the hotel is not found.

#### 4. **Delete Hotel**
   - **URL:** `/HotelController/delete/{id}`
   - **Method:** `DELETE`
   - **Description:** Deletes a specific hotel.
   - **Path Parameter:**
     - `id`: The unique ID of the hotel to be deleted.
   - **Response:**
     - Success: `200 OK` if hotel is deleted.
     - Failure: `404 Not Found` if hotel does not exist.
     - Failure: `500 Internal Server Error` if deletion fails.

#### 5. **Get Hotel by ID**
   - **URL:** `/HotelController/get/{id}`
   - **Method:** `GET`
   - **Description:** Retrieves the details of a specific hotel by its ID.
   - **Path Parameter:**
     - `id`: The unique ID of the hotel.
   - **Response:**
     - Success: `200 OK` with hotel details.
     - Failure: `404 Not Found` if hotel does not exist.

#### 6. **Search Hotel by Name**
   - **URL:** `/HotelController/searchByName/{name}`
   - **Method:** `GET`
   - **Description:** Searches for a hotel by name.
   - **Path Parameter:**
     - `name`: The name of the hotel to search for.
   - **Response:**
     - Success: `200 OK` with hotel data.
     - Failure: `404 Not Found` if no hotel is found.

#### 7. **Book Hotel Room**
   - **URL:** `/HotelController/bookRoom/{hotelId}/{roomType}`
   - **Method:** `POST`
   - **Description:** Books a room at a specified hotel.
   - **Path Parameters:**
     - `hotelId`: The ID of the hotel.
     - `roomType`: The type of room (e.g., Single, Double, Family).
   - **Response:**
     - Success: `200 OK` if room is booked.
     - Failure: `500 Internal Server Error` if the booking fails.

---

### **Notification API (Port 8080)**

#### 1. **Send Notification**
   - **URL:** `/api/notification/send-notification`
   - **Method:** `GET`
   - **Description:** Sends a notification to users (e.g., booking confirmations, event reminders).
   - **Parameters:**
     - `message`: The message content to be sent as a notification.
   - **Response:**
     - Success: `200 OK`
     - Failure: `400 Bad Request` if the message is invalid.

---

## Testing

To test the APIs, use **Postman** or any API testing tool:

1. **Testing Hotel Booking:**
   - **Method:** `POST`
   - **URL:** `http://localhost:8081/HotelController/bookRoom/{hotelId}/{roomType}`
   
2. **Testing Event Booking:**
   - **Method:** `POST`
   - **URL:** `http://localhost:8081/api/event/bookTicket/{eventId}`
   
3. **Testing Notification:**
   - **Method:** `GET`
   - **URL:** `http://localhost:8080/api/notification/send-notification?message=Booking%20confirmed%20for%20event%20XYZ`

---

## Future Enhancements

1. **User Authentication & Authorization**: Implement JWT-based authentication for secure access to the system

.
2. **Payment Gateway Integration**: Integrate with payment providers to allow users to pay for bookings online.
3. **Mobile App Support**: Develop a mobile version of the platform for easier access and management of bookings.

---

### License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

