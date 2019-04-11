package nl.qien.motorbike.model;

import java.io.Serializable;

public class Car implements Serializable {

    private long id;
    private String licensePlate;
    private int mileage;

    public Car() {

    }

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
