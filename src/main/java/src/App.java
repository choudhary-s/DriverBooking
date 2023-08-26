package src;

import src.managers.BookingsManager;
import src.managers.DriverManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
    static BookingsManager bookingsManager;
    static DriverManager driverManager;
    public static void main( String[] args )throws IOException {
        bookingsManager = new BookingsManager();
        driverManager = new DriverManager();


        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] command = br.readLine().trim().split(" ");
            switch (command[0]){
                case "register_driver":
                    String id = command[1];
                    registerDriver(id);
                    break;
                case "dispatch_driver_for_a_booking":
                    double distance = Double.parseDouble(command[1].trim());
                    createBooking(distance);
                    break;
                case "complete_booking":
                    String bookingId = command[1].trim();
                    markBookingCompleted(bookingId);
                    break;
                default:
                    System.out.println("Invalid command. Enter again");
            }
        }
    }
    public static void registerDriver(String id){
        boolean isSuccess = driverManager.registerDriver(id);
        if(isSuccess){
            System.out.println("Driver "+id+" registered");
        }
        else{
            System.out.println("Error");
        }
    }
    public static void createBooking(double distance){
        String bookingId = bookingsManager.createBooking(distance);
    }
    public static void markBookingCompleted(String bookingId){
        bookingsManager.markBookingComplete(bookingId);
    }
}
