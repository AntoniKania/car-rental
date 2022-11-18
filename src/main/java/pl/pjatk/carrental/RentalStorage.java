package pl.pjatk.carrental;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentalStorage {
    private final List<Rental> rentalList = new ArrayList<>();

    public RentalStorage() {
        rentalList.add(new Rental(new User("1"), new Car("Opel", "Astra", "1234", CarType.STANDARD)));
        rentalList.add(new Rental(new User("2"), new Car("Skoda", "Octavia", "133", CarType.STANDARD)));
    }
    public void addNewRental(Rental rental) {
        rentalList.add(rental);
    }
    public List<Rental> getRentalList() {
        return rentalList;
    }

}
