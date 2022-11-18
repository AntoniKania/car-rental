package pl.pjatk.carrental;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarService {
    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;
    public CarService(CarStorage carStorage, RentalStorage rentalStorage) {
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }
    public Rental rentCar(User user, String vin) {
        if (rentalStorage.getRentalList().stream()
                .map(Rental::getCar)
                .anyMatch(car -> car.getVin().equals(vin))) {
            System.out.println("Car is currently rented");
            return null;
        }

        Optional<Car> car = carStorage.getCarList().stream()
                .filter(storage -> storage.getVin().equals(vin))
                .findFirst();

        if(car.isEmpty()) {
            System.out.println("Car with this vin doesn't exist in database");
            return null;
        }

        Rental rental = new Rental(user, car.get());
        rentalStorage.addNewRental(rental);
        return rental;
    }
    public List<Car> getAllCars() {
        return carStorage.getCarList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }
}
