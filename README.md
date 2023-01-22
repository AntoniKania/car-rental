# Spring Boot Car Rental Application

This application is built using the Spring Boot framework and the Model-View-Controller (MVC) pattern. It allows for car rental operations to be performed through the **CarService** class, which acts as the controller.

## Functionality

The application does not have a database and instead uses storage classes (**CarStorage** and **RentalStorage**) to store the necessary information in a List data structure. The **CarService** class contains all the logic for performing car rental operations.

## Testing

The CarService class has been tested using two types of tests:

* Unit tests (with mocking and without mocking)
* Integration test

Both types of tests ensure that the **CarService** class is functioning correctly and that all logic is working as intended.

## Running the Application
To run the application, you will need to have the Spring Boot framework and a Java development environment set up on your machine. Once those are in place, you can run the application by executing the **main** method in the **CarRentalApplication** class.
