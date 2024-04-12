# Parking Rental App Functionality Checklist

## 1. Main Menu:
- [ ] Display a menu with different options to the user.
- [ ] Implement user input handling for menu options.
- [ ] Implement the exit functionality.

## 2. Creating Parking Spots:
- [ ] Implement a method to create parking spots and associate them with a parking lot.

## 3. Displaying Parking Spots:
- [ ] Implement a method to display all parking spots along with their occupancy status.

## 4. Registering Customers:
- [ ] Implement a method to collect customer information.
- [ ] Implement a method to collect vehicle information.
- [ ] Display the registration data to the user.

## 5. Reserving Parking Spots:
- [ ] Implement a method to reserve a parking spot for a customer.
- [ ] Check if the customer has already reserved a spot.
- [ ] Check if the parking spot is already reserved or occupied.
- [ ] Update the occupancy status of the reserved spot.
- [ ] Associate the reservation with the customer and their vehicle.

## 6. Displaying and Vacating Reserved Parking:
- [ ] Display customer information and their current reservation.
- [ ] Get the parking spot number from the user.
- [ ] Check if the parking spot number is valid and if there is a reservation for it.
- [ ] Vacate the parking spot and remove the reservation.

## 7. Data Access Objects (DAOs):
- [ ] Implement DAO interfaces for Customer, ParkingLot, ParkingSpot, Reservation, and Vehicle.
- [ ] Define methods for creating, finding, and removing objects in the DAO interfaces.

## 8. User Interface (UI):
- [ ] Implement methods in the ConsoleUI class for displaying menus, collecting user input, and presenting information.

## 9. Model Classes:
- [ ] Review and ensure the correctness of the Customer, ParkingLot, ParkingSpot, Reservation, and Vehicle classes.

## 10. Testing:
- [ ] Write unit tests for each of the DAO implementations.
- [ ] Test the functionality of different methods in the Controller class.

## 11. Error Handling:
- [ ] Implement error handling for invalid inputs and unexpected scenarios.
- [ ] Ensure that proper messages are displayed to the user in case of errors.

## 12. Additional Features (if applicable):
- [ ] If you plan to expand the application, consider adding features like payment processing, viewing reservation history, or administrative actions.
