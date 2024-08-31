import java.util.ArrayList;
import java.util.Date;
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
    public void cancelReservation(int number,Client c){
        for (Reservation r : this.reservations) {
            if (r.client == c && r.room.getNumber() == number) {
                r.room.setAvailable(true);
                this.reservations.remove(r);
                break;
            }
        }
    }

    public void bookRoom(Client client, Room room, Date checkIn, Date checkOut) {
        Reservation reservation = new Reservation(this.reservations.size() + 1, client, room, checkIn, checkOut);
        this.reservations.add(reservation);
        room.setAvailable(false);
    }

    public void changeReservation(int id, int roomNumber, Date checkIn, Date checkOut, Client c) {
        for (Reservation r : this.reservations) {
            if (r.id == id && r.client == c) {
                for (Room room1 : this.rooms) {
                    if (room1.getNumber() == roomNumber && room1.isAvailable()) {
                        r.room.setAvailable(true);
                        r.room = room1;
                        r.checkIn = checkIn;
                        r.checkOut = checkOut;
                        room1.setAvailable(false);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                ", reservations=" + reservations +
                '}';
    }
}
