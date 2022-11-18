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
    private boolean isCarAvailable(String vin) {
        if (carStorage.getCarList().stream()
                .noneMatch(car -> car.getVin().equals(vin))) {
            return false;
        }
        return rentalStorage.getRentalList().stream()
                .map(Rental::getCar)
                .anyMatch(car -> car.getVin().equals(vin));
    }

    public Rental rentCar(User user, String vin) {
        if (!isCarAvailable(vin)) {
            System.out.println("Car is unavailable");
            return null;
        }
        Optional<Car> car = carStorage.getCarList().stream()
                .filter(storage -> storage.getVin().equals(vin))
                .findFirst();

        if(car.isEmpty()) {
            System.out.print("Car with this vin doesn't exist in database");
            return null;
        }

        return new Rental(user, car.get()); //dodać wsadzanie rentala do rental storage
    }

    public List<Car> getAllCars() {
        return carStorage.getCarList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }
    /*
    isAvailable()
    List<Car> listOfRentCars // co jezeli mamy kilka aut tego samego modelu?

1 metoda: sprawdzenie cz istnieje w carstorage2 metoda:
sprawdzenie czy istnieje w rentalstorage
    createNewCLient()
    rentCar(client, car)
    */
}
