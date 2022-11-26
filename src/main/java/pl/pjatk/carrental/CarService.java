package pl.pjatk.carrental;

import org.springframework.stereotype.Component;
import pl.pjatk.carrental.model.Car;
import pl.pjatk.carrental.model.Rental;
import pl.pjatk.carrental.model.RentalInfo;
import pl.pjatk.carrental.model.User;
import pl.pjatk.carrental.storage.CarStorage;
import pl.pjatk.carrental.storage.RentalStorage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Component
public class CarService {
    private static final int BASE_PRICE = 300;
    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;
    public CarService(CarStorage carStorage, RentalStorage rentalStorage) {
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }
    public RentalInfo rentCar(User user, String vin, LocalDate startDate, LocalDate endDate) {
        double price;
        long numberOfDays = calculateNumberOfDays(startDate, endDate);
        Optional<Car> car = getOptionalCar(vin);
        if(car.isEmpty()) {
            System.out.println("Car with this vin doesn't exist in database");
            return null;
        }

        if (isAlreadyRented(vin)) {
            System.out.println("Car is currently rented");
            return null;
        }

        if (numberOfDays < 1) {
            System.out.println("Invalid time slot given");
            return null;
        }

        price = calculatePrice(car.get(), numberOfDays);
        rentalStorage.addNewRental(new Rental(user, car.get()));

        return new RentalInfo(price, startDate, endDate);
    }

    private Optional<Car> getOptionalCar(String vin) {
        return carStorage.getCarList().stream()
                .filter(storage -> storage.getVin().equals(vin))
                .findFirst();
    }

    private boolean isAlreadyRented(String vin) {
        return rentalStorage.getRentalList().stream()
                .map(Rental::getCar)
                .anyMatch(car -> car.getVin().equals(vin));
    }

    private long calculateNumberOfDays(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
    private double calculatePrice(Car car, long numberOfDays) {
        return car.getCarType().getMultiplier() * BASE_PRICE * numberOfDays;
    }

    public List<Car> getAllCars() {
        return carStorage.getCarList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }
}
