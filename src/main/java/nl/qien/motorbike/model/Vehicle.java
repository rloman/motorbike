package nl.qien.motorbike.model;

import javax.persistence.Entity;

@Entity
public abstract class Vehicle extends AbstractEntity {

    private boolean motorVehicle;

    public boolean isMotorVehicle() {
        return motorVehicle;
    }

    public void setMotorVehicle(boolean motorVehicle) {
        this.motorVehicle = motorVehicle;
    }
}
