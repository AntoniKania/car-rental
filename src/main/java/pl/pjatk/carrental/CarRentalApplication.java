package pl.pjatk.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRentalApplication {

	public CarRentalApplication(CarService carService) {
//		System.out.println(carService.getAllCars());
//		System.out.println(carService.getAllRentals());
		carService.rentCar(new User("1"), "1234");
	}

	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
	}

}
