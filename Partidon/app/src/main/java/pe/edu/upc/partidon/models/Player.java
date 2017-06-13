package pe.edu.upc.partidon.models;

/**
 * Created by Hector on 11/06/2017.
 */

public class Player {

    int id_player;
    String name;
    String email;
    String address;
    String icon;

    public Player() {
    }

    public Player(int id_player, String name, String email, String address, String icon) {
        this.id_player = id_player;
        this.name = name;
        this.email = email;
        this.address = address;
        this.icon = icon;
    }

    public int getId_player() {
        return id_player;
    }
    public String getId_playerAsString() {
        return String.format("%d", id_player);
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
