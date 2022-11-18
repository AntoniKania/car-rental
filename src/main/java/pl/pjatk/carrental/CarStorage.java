package pl.pjatk.carrental;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarStorage {
    private final List<Car> carList = new ArrayList<Car>();

    public CarStorage() {
        carList.add(new Car("Opel", "Astra", "1234", CarType.STANDARD));
        carList.add(new Car("Fiat", "Punto", "4321", CarType.STANDARD));
        carList.add(new Car("Porsche ", "Cayenne", "9876", CarType.PREMIUM));
    }

    public List<Car> getCarList() {
        return carList;
    }
}
