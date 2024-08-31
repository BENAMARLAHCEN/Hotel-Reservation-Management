import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Client LoginClient = null;
        int roomNumber;
        // Create a new hotel
        Hotel hotel = new Hotel("Hotel California");

        // Create a new room
        Room room = new Room(101);
        Room room2 = new Room(102);
        Room room3 = new Room(103);
        Room room4 = new Room(104);
        Room room5 = new Room(105);

        // Add the room to the hotel
        hotel.addRoom(room);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);
        hotel.addRoom(room5);

        // Create a new client
        Client client = new Client("123456", "Mohamed", "test@test.com", "password");
        Client client2 = new Client("123457", "Anass", "test2@test.com", "password");
        List<Client> Clients = new ArrayList<>();
        Clients.add(client);
        Clients.add(client2);

        // Login the client to the hotel
        boolean loggedIn = false;
        do {
            System.out.println("=====================================================================");
            System.out.println("Welcome to " + hotel.getName());
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.println("=====================================================================");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.print("Enter your email: ");
                String email = scan.next();
                System.out.print("Enter your password: ");
                String password = scan.next();
                for (Client c : Clients) {
                    if (c.email.equals(email) && c.password.equals(password)) {
                        LoginClient = c;
                        loggedIn = true;
                        break;
                    }
                }
                if (LoginClient == null) {
                    System.out.println("Invalid email or password");
                }
            } else if (choice == 2) {
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
            }
            System.out.println("=====================================================================");
        } while (!loggedIn);

// Create a new reservation or cancel a reservation or check available rooms check my reservations
        System.out.println("1. Check available rooms");
        System.out.println("2. Check my reservations");
        System.out.println("3. Book a room");
        System.out.println("4. Cancel a reservation");
        System.out.println("5. Modify a reservation");
        System.out.println("6. Exit");
        do {
            System.out.println("=====================================================================");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("=====================================================================");
                    for (Room r : hotel.getRooms()) {
                        if (r.isAvailable()) {
                            System.out.println("Room number: " + r.getNumber());
                        }
                    }
                    System.out.println("=====================================================================");
                    break;
                case 2:
                    for (Reservation r : hotel.getReservations()) {
                        if (r.client == LoginClient) {
                            System.out.println("=====================================================================");
                            System.out.println("Reservation ID: " + r.id);
                            System.out.println("Room number: " + r.room.getNumber());
                            System.out.println("Check in: " + r.checkIn);
                            System.out.println("Check out: " + r.checkOut);
                            System.out.println("=====================================================================");
                        }
                    }
                    break;
                case 3:
                    System.out.println("=====================================================================");
                    System.out.println("Enter the room number: ");
                    roomNumber = scan.nextInt();
                    for (Room r : hotel.getRooms()) {
                        if (r.getNumber() == roomNumber && r.isAvailable()) {
                            System.out.println("Enter the check in date (format: dd-MM-yyyy): ");
                            String date = scan.next();
                            Date checkIn = parseDate(date);
                            System.out.println("Enter the check out date (format: dd-MM-yyyy): ");
                            String dateEnd = scan.next();
                            Date checkOut = parseDate(dateEnd);
                            hotel.bookRoom(LoginClient, r, checkIn, checkOut);
                            break;
                        }
                    }
                    System.out.println("=====================================================================");
                    break;
                case 4:
                    System.out.println("Enter the room number: ");
                    roomNumber = scan.nextInt();
                    hotel.cancelReservation(roomNumber, LoginClient);
                    break;
                case 5:
                    System.out.println("=====================================================================");
                    System.out.println("Enter the reservation id:");
                    int reservID = scan.nextInt();
                    System.out.println("Enter the new room number: ");
                    roomNumber = scan.nextInt();
                    System.out.println("Enter the new check in date (format: dd-MM-yyyy): ");
                    String date = scan.next();
                    Date checkIn = parseDate(date);
                    System.out.println("Enter the new check in date (format: dd-MM-yyyy): ");
                    String dateEnd = scan.next();
                    Date checkOut = parseDate(dateEnd);
                    hotel.changeReservation(reservID,roomNumber,checkIn,checkOut,LoginClient);
                    System.out.println("=====================================================================");
                    break;

                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (true);

    }

    static Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}