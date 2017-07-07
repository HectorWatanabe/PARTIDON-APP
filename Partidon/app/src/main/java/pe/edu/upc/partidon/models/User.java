package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 26/05/2017.
 */

public class User {

    @SerializedName("id")
    private int id;
    @SerializedName("api_token")
    private String api_token;
    @SerializedName("name")
    private String name;
    @SerializedName("address")
    private String address;
    @SerializedName("email")
    private String email;
    @SerializedName("icon_image")
    private String icon_image;
    private int sport;


    public enum Type{
        None(-1), Basket(1), Soccer(2), Tennis(3);
        private int type;
        Type(int type) {
            this.type = type;
        }
        public int getType() { return type; }
        public static User.Type from(int type){
            switch (type){
                case 1: return Basket;
                case 2: return Soccer;
                case 3: return Tennis;
                default: return None;
            }
        }
    }


    public User() {
    }

    public User(int id, String api_token, String name, String address, String email, String icon_image, int sport) {
        this.id = id;
        this.api_token = api_token;
        this.name = name;
        this.address = address;
        this.email = email;
        this.icon_image = icon_image;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public int getId() {
        return id;
    }

    public String getIdAsString() {
        return String.format("%d", id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSport() {
        return sport;
    }
    public String getSportAsString() {
        return String.format("%d", sport);
    }

    public void setSport(int sport) {
        this.sport = sport;
    }


    public Type getType(){
        return Type.from(sport);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon_image() {
        return icon_image;
    }

    public void setIcon_image(String icon_image) {
        this.icon_image = icon_image;
    }

}
