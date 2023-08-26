package src.managers;

import org.junit.Assert;
import org.junit.Test;

public class DriverManagerTest {
    DriverManager driverManager = new DriverManager();
    @Test
    public void registerDriverTest(){
        driverManager.registerDriver("driver-001");
        driverManager.registerDriver("driver-002");
        Assert.assertTrue(driverManager.getDriverStore().getDriverList().size()==2);
    }
}
