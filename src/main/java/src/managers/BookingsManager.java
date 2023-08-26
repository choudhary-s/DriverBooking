package src.managers;

import lombok.Data;
import src.datastores.BookingsStore;
import src.datastores.DriverStore;
import src.entity.Bookings;
import src.entity.Driver;
import src.enums.AvailabilityStatus;

import java.util.List;

@Data
public class BookingsManager {

    DriverStore driverStore;
    BookingsStore bookingsStore;

    public BookingsManager(){
        driverStore = DriverStore.getInstance();
        bookingsStore = BookingsStore.getInstance();
    }

    public String createBooking(double distance){
        //search for a free driver
        //create a booking with driver
        //return bookingid (format booking-<id>)
        Driver freeDriver = searchFreeDriver();
        if(freeDriver==null){
            System.out.println("Sorry, driver is not available");
            return null;
        }
        Bookings createdBooking = createBooking(freeDriver, distance);
        String bookingIdToReturn = "booking-"+createdBooking.getId();
        System.out.println("Driver "+freeDriver.getId()+" is assigned to booking "+bookingIdToReturn+" with "+distance+" km distance");
        return "booking-"+createdBooking.getId();
    }

    public boolean markBookingComplete(String bookingId){

        //search in the booking store for id
        //mark that booking as complete
        //return true;
        int id = Integer.parseInt(bookingId.split("-")[1]);
        Bookings bookings = bookingsStore.getBooking(id);
        if(bookings==null){
            System.out.println("No such booking in booking store");
            return false;
        }
        if(bookings.isComplete()==true){
            System.out.println("Booking is already marked complete");
            return false;
        }
        bookings.setComplete(true);
        freeDriver(bookings.getDriverId());
        System.out.println("Driver "+bookings.getDriverId()+" is released to allocation pool");
        return true;
    }
    public Driver searchFreeDriver(){
        List<Driver> driverList = driverStore.getDriverList();
        for(Driver d: driverList){
            if(d.getAvlStatus()== AvailabilityStatus.AVAILABLE){
                return d;
            }
        }
        return null;
    }
    public Bookings createBooking(Driver d, double distance){
        d.setAvlStatus(AvailabilityStatus.NOT_AVAILABLE);
        return bookingsStore.createBooking(d.getId(), distance);
    }
    public void freeDriver(String driverId){
        for(Driver d: driverStore.getDriverList()){
            if(d.getId().equals(driverId)){
                d.setAvlStatus(AvailabilityStatus.AVAILABLE);
                return;
            }
        }
    }
}
