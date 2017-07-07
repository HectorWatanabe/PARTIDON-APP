package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 28/05/2017.
 */

public class CourtSection {

    @SerializedName("id")
    private int id;
    @SerializedName("material")
    private String type;
    @SerializedName("size")
    private String metre;
    @SerializedName("seat")
    private Boolean chair;
    @SerializedName("price")
    private double price;
    @SerializedName("offer")
    private double sale;
    @SerializedName("image1")
    private String image1;
    @SerializedName("image2")
    private String image2;

    public CourtSection() {
    }

    public CourtSection(int id, String type, String metre, Boolean chair, double price, double sale, String image1, String image2) {
        this.id = id;
        this.type = type;
        this.metre = metre;
        this.chair = chair;
        this.price = price;
        this.sale = sale;
        this.image1 = image1;
        this.image2 = image2;
    }

    public int getId() {
        return id;
    }

    public String getIdAsString() {
        return String.format("%d", id);
    }

    public CourtSection setId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public CourtSection setType(String type) {
        this.type = type;
        return this;
    }

    public String getMetre() {
        return metre;
    }

    public CourtSection setMetre(String metre) {
        this.metre = metre;
        return this;
    }

    public Boolean getChair() {
        return chair;
    }

    public CourtSection setChair(Boolean chair) {
        this.chair = chair;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceAsString() {
        return String.format("%.2f", price);
    }

    public CourtSection setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getSale() {
        return sale;
    }
    public String getSaleAsString() {
        return String.format("%.2f", sale);
    }

    public CourtSection setSale(double sale) {
        this.sale = sale;
        return this;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }
}
