package src.entity;

import lombok.Data;

@Data
public class Bookings {
    int id;
    String driverId;
    double distance;
    boolean isComplete;

    public Bookings(int id, String driverId, double distance){
        this.id = id;
        this.driverId = driverId;
        this.distance = distance;
        this.isComplete = false;
    }
}
