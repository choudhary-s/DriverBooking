package src.managers;

import lombok.Data;
import src.datastores.DriverStore;

@Data
public class DriverManager {
    DriverStore driverStore;

    public DriverManager(){
        this.driverStore = DriverStore.getInstance();
    }

    public boolean registerDriver(String id){
        return driverStore.addDriver(id);
    }
}
