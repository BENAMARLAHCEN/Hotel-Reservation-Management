public class Client {
    public String CIN;
    public String name;
    public String email;
    public String password;

    public Client(String CIN, String name, String email, String password) {
        this.CIN = CIN;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "CIN='" + CIN + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' ;
    }
}
