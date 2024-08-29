import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final String name;
    private final List<Room> rooms;
    private final List<Reservation> reservations;

    public Hotel(String name) {
        this.name = name;
           this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }
     public void addRoom(Room room) {
         this.rooms.add(room);
    }
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
    public List<Room> getRooms() {
        return this.rooms;
    }
    public List<Reservation> getReservations() {
        return this.reservations;
    }
    public String getName() {
        return this.name;
    }
    public void cancelReservation(Reservation reservation) {
        this.reservations.remove(reservation);
        reservation.cancel();
    }


}
