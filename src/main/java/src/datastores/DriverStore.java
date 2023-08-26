package src.datastores;

import lombok.Data;
import src.entity.Driver;

import java.util.ArrayList;
import java.util.List;

@Data
public class DriverStore {
    static DriverStore driverStore;
    List<Driver> driverList;

    private DriverStore(){
        driverList = new ArrayList<>();
    }

    public static DriverStore getInstance(){
        if(driverStore==null){
            driverStore = new DriverStore();
        }
        return driverStore;
    }
    public boolean addDriver(String id){
        try {
            Driver driver = new Driver(id);
            driverList.add(driver);
            return true;
        }
        catch (Exception ex){
            System.out.println("Unexpected error occurred. Error msg: "+ex.getMessage());
            return false;
        }
    }
}
