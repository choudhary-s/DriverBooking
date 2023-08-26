package src.entity;

import lombok.Data;
import src.enums.AvailabilityStatus;

@Data
public class Driver {
    String id;
    AvailabilityStatus avlStatus;

    public Driver(String id){
        this.id = id;
        avlStatus = AvailabilityStatus.AVAILABLE;
    }
}
