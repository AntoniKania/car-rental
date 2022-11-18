package pl.pjatk.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRentalApplication {

	public CarRentalApplication(CarService carService) {
//		System.out.println(carService.getAllCars());
//		System.out.println(carService.getAllRentals());
		Rental testRental = carService.rentCar(new User("1"), "4321");
		System.out.println(testRental);
	}

	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
	}

}
