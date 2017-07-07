package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by user on 22/05/2017.
 */

public class Court {


    @SerializedName("id")
    private int id;
    @SerializedName("district")
    private String district;
    @SerializedName("phone_number")
    private String phone;
    @SerializedName("description")
    private String description;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("length")
    private String length;
    private User user;
    private List<Business> businesses;


    public Court() {
    }

    public Court(int id, String district, String phone, String description, String latitude, String length, User user, List<Business> businesses) {
        this.id = id;
        this.district = district;
        this.phone = phone;
        this.description = description;
        this.latitude = latitude;
        this.length = length;
        this.user = user;
        this.businesses = businesses;
    }

    public int getId() {
        return id;
    }

    public Court setId(int id) {
        this.id = id;
        return this;

    }
    public String getIdAsString() {
        return String.format("%d", id);
    }


    public String getDistrict() {
        return district;
    }

    public Court setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }
}

