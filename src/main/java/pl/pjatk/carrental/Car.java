package pl.pjatk.carrental;

public class Car {
    private String make;
    private String model;
    private String vin;
    private CarType carType;

    public Car(String make, String model, String vin, CarType carType) {
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.carType = carType;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", luxuryClass='" + carType + '\'' +
                '}';
    }
}
