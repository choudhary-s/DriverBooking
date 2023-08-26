package src.datastores;

import lombok.Data;
import src.entity.Bookings;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookingsStore {
    static BookingsStore bookingsStore;
    List<Bookings> bookingsList;

    private BookingsStore(){
        bookingsList = new ArrayList<>();
    }

    public static BookingsStore getInstance(){
        if(bookingsStore==null){
            bookingsStore = new BookingsStore();
        }
        return bookingsStore;
    }
    public Bookings createBooking(String driverId, double distance){
        try {
            int bookingsId = bookingsList.size() + 1;
            Bookings bookings = new Bookings(bookingsId, driverId, distance);
            bookingsList.add(bookings);
            return bookings;
        }
        catch (Exception ex){
            System.out.println("Unexpected error occurred. Error msg: "+ex.getMessage());
            return null;
        }
    }
    public Bookings getBooking(int id){
        for(Bookings b: bookingsList){
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }
}
