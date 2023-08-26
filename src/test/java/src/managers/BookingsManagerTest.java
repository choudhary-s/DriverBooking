package src.managers;

import org.junit.Assert;
import org.junit.Test;
import src.entity.Driver;

public class BookingsManagerTest {
    BookingsManager bookingsManager = new BookingsManager();

    @Test
    public void searchFreeDriverTest(){
        Driver d = bookingsManager.searchFreeDriver();
        Assert.assertTrue(d==null);
        DriverManager driverManager = new DriverManager();
        driverManager.registerDriver("driver-001");
        d = bookingsManager.searchFreeDriver();
        Assert.assertTrue(d!=null);
    }

}
