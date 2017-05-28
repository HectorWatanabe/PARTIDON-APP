package pe.edu.upc.partidon.models;

/**
 * Created by user on 26/05/2017.
 */

public class User {
    private String id;
    private String token;
    private String nameUser;
    private String location;
    public User() {
    }

    public User(String nameUser, String location) {
        this.nameUser = nameUser;
        this.location = location;
    }

    public String getNameUser() {
        return nameUser;
    }

    public User setNameUser(String nameUser) {
        this.nameUser = nameUser;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public User setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
