package pe.edu.upc.partidon.models;

/**
 * Created by user on 28/05/2017.
 */

public class CourtSection {

    private int id;
    private String title;
    private String tipe;
    private String metre;
    private String chair;
    private double price;
    private double sale;

    public CourtSection() {
    }

    public CourtSection(int id, String title, String tipe, String metre, String chair, double price, double sale) {
        this.id = id;
        this.title = title;
        this.tipe = tipe;
        this.metre = metre;
        this.chair = chair;
        this.price = price;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public CourtSection setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CourtSection setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTipe() {
        return tipe;
    }

    public CourtSection setTipe(String tipe) {
        this.tipe = tipe;
        return this;
    }

    public String getMetre() {
        return metre;
    }

    public CourtSection setMetre(String metre) {
        this.metre = metre;
        return this;
    }

    public String getChair() {
        return chair;
    }

    public CourtSection setChair(String chair) {
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
}
