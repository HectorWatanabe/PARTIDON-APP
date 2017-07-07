package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hector on 29/06/2017.
 */

public class Business {


    @SerializedName("id")
    int id;

    @SerializedName("company_id")
    int company_id;

    @SerializedName("sport_id")
    int sport;

    public Business() {
    }

    public Business(int id, int company_id, int sport) {
        this.id = id;
        this.company_id = company_id;
        this.sport = sport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdAsString() {
        return String.format("%d", id);
    }

    public int getCompany_id() {
        return company_id;
    }
    public String getCompany_idAsString() {
        return String.format("%d", company_id);
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
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
}
