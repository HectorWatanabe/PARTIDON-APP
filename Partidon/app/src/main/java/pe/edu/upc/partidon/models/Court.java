package pe.edu.upc.partidon.models;

import android.graphics.drawable.Drawable;

/**
 * Created by user on 22/05/2017.
 */

public class Court {

    private int id;
    private String title;
    private String distrit;
    private double price;

    public Court() {
    }

    public Court(int id, String title, String distrit, double price) {
        this.id = id;
        this.title = title;
        this.distrit = distrit;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Court setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Court setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDistrit() {
        return distrit;
    }

    public Court setDistrit(String distrit) {
        this.distrit = distrit;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Court setPrice(double price) {
        this.price = price;
        return this;
    }
    public String getPriceAsString() {
        return String.format("%.2f", price);
    }



}
