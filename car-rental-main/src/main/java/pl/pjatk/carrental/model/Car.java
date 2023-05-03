package pl.pjatk.carrental.model;

public class Car {
    private final String make;
    private final String model;
    private final String vin;
    private final CarType carType;

    public Car(String make, String model, String vin, CarType carType) {
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.carType = carType;
    }

    public Car() {
        this.make = null;
        this.model = null;
        this.vin = null;
        this.carType = null;
    }

    public String getVin() {
        return vin;
    }
    public CarType getCarType() {
        return carType;
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
