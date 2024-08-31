import java.util.Date;

public class Reservation {
    public int id;
    public Client client;
    public Room room;
    public Date checkIn;
    public Date checkOut;

    public Reservation(int id, Client client, Room room, Date checkIn, Date checkOut) {
        this.id = id;
        this.client = client;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void cancel() {
        this.room.setAvailable(true);
    }



}
