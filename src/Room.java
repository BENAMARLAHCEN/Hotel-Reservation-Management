public class Room {
    private final int number;
    private Boolean isAvailable;

    public Room(int number) {
        this.number = number;
        this.isAvailable = true;
    }

    public int getNumber() {
        return this.number;
    }

    public Boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(Boolean available) {
        this.isAvailable = available;
    }
}
