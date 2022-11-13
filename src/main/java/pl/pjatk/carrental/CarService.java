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
    public List<Car> getAllCars() {
        return carStorage.getCarList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }
    public Rental rentCar(User user, String vin) {
        if (carStorage.getCarList().stream().noneMatch(car -> car.getVin().equals(vin))) {
            return null;
        }
        Optional<Rental> first = rentalStorage.getRentalList().stream()
                .filter(rental -> rental.getCar().getVin().equals(vin))
                .findFirst();
        if (rentalStorage.getRentalList().stream()
                .map(Rental::getCar)
                .anyMatch(car -> car.getVin().equals(vin))) {
            System.out.println("auto jest wypozyczone");
            return null;
        }
        System.out.println("wypozyczenia auta");
        new Rental(new User("1"), carStorage.getCarList().stream().)

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
