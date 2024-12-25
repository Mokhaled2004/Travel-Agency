

# Travel Agency System

## Project Overview

The **Travel Agency System** is a backend application designed to simulate an online travel agency for booking hotel rooms and event tickets. It interacts with the frontend through APIs and offers functionality for booking, searching, and managing reservations. This project focuses on the **backend** of the system and is a component of a larger travel management software.

### Key Features:

- **Hotel Booking**: Users can view, search, and book different types of hotel rooms (single, double, family).
- **Event Ticket Booking**: Users can search and book tickets for local events.
- **User Accounts**: Users must create an account to book hotels or event tickets.
- **Booking Dashboard**: Users have access to a dashboard that displays and allows them to print their bookings.
- **Event Recommendations**: Based on hotel bookings, users are recommended nearby events that align with their travel dates.
- **Notification System**: A notification module alerts users of their bookings, nearby events, offers, and promotions.
- **Event API Integration**: Event data is retrieved via an external API for local event details.
  
The system includes a **notification module** to handle multiple types of notifications (email, SMS) for various actions such as confirmations, password resets, and booking updates.

## Architecture

### **Backend Services**
- **Travel Agency Backend**: Handles hotel bookings, event ticket purchases, and user data.
  - Runs on port `8081`
  
- **Notification Service**: A dedicated service for sending notifications to users (e.g., email confirmations, SMS updates).
  - Runs on port `8080`

### **Features in Detail**
1. **Hotel Booking**:
   - Search and book rooms (single, double, family).
   - Integration with hotel providers or a local database for room availability.
   
2. **Event Booking**:
   - Search and book tickets for local events.
   - Event details are consumed from an external events API.

3. **User Dashboard**:
   - View, search, and print booking details.
   - Event recommendations based on hotel bookings and user location.

4. **Notification System**:
   - **Notification Templates**: Manage different templates for notifications (email, SMS).
   - **Queuing System**: Notifications are queued for asynchronous delivery to avoid blocking user interactions.
   - **Sending/Queue Handling**: Actual notification sending from the queue.
   - **Notification Statistics**: Provides insights into sent/failed notifications, including failure reasons, most notified users, and most used templates.

### **System Workflow**

1. **User Registration**:
   - Users must register to book hotels or events.
   
2. **Hotel Booking**:
   - Users search and book hotel rooms via the API.
   
3. **Event Booking**:
   - Upon booking a hotel, users receive event recommendations for local events during their stay.
   
4. **Notification System**:
   - The notification service handles email and SMS alerts, including booking confirmations and event reminders.
   - The system queues notifications to prevent delay in user requests.

## Installation

### Requirements:
- **Node.js** for backend and notification services.
- **MongoDB** or a similar database for storing user and booking data.
- **External Event API** (for fetching event data).
- **Email/SMS Service** (for sending notifications).

### Steps to Install:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Mokhaled2004/Travel-Agency.git
   cd Travel-Agency
   ```

2. **Install dependencies**:
   Navigate to the backend directory and install the necessary Node.js dependencies:
   ```bash
   npm install
   ```

3. **Set up the Notification Service**:
   - Navigate to the `notification-service` directory and install dependencies:
     ```bash
     cd notification-service
     npm install
     ```

4. **Configure environment variables**:
   - Create a `.env` file in the root directory and set the necessary environment variables (e.g., database connection string, external API keys, email/SMS service credentials).

5. **Start the Backend Service**:
   ```bash
   npm start
   ```
   The backend will run on port `8081`.

6. **Start the Notification Service**:
   ```bash
   npm start
   ```
   The notification service will run on port `8080`.

## API Endpoints

### **Travel Agency Backend (Port 8081)**

- **GET /hotels**: Retrieve available hotel rooms.
- **POST /book-hotel**: Book a hotel room.
- **GET /events**: Fetch available local events from the external events API.
- **POST /book-event**: Book a ticket for an event.
- **POST /user/register**: Register a new user.

### **Notification Service (Port 8080)**

- **POST /send-notification**: Sends a notification (email/SMS) to a user.
- **GET /notification-stats**: Retrieve notification statistics (successful/failed sends, most notified users, etc.).

## Design for Reuse - Notification Module

The notification system is designed for reuse across multiple applications. It includes:

- **Notification Template Management**: Allows defining various notification templates (e.g., booking confirmations, event reminders) with placeholders for dynamic data.
- **Notification Queuing**: Queues notifications for asynchronous processing to avoid blocking the main application.
- **Notification Sending/Queue Handling**: De-queues and sends notifications.
- **Statistics**: Tracks sent and failed notifications, including the failure reason, most used templates, and most notified users.

## Technologies Used

- **Node.js**: Backend and notification service implementation.
- **Express.js**: API framework for building backend services.
- **MongoDB**: Database for storing user and booking information.
- **External Event API**: Fetching event data for local events.
- **Email/SMS Service**: For sending notifications.

## Contributing

If you’d like to contribute to this project, feel free to fork the repository, create a branch, and submit a pull request. Please make sure to follow the coding conventions and include tests where applicable.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

