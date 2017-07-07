package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hector on 04/07/2017.
 */

public class BusinessesBySport {


    @SerializedName("id")
    int id;
    @SerializedName("company_id")
    int company_id;
    @SerializedName("sport_id")
    int sport_id;
    @SerializedName("company")
    Court court;

    public BusinessesBySport() {
    }

    public BusinessesBySport(int id, int company_id, int sport_id, Court court) {
        this.id = id;
        this.company_id = company_id;
        this.sport_id = sport_id;
        this.court = court;
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

    public int getCompany_id() {
        return company_id;
    }

    public String getCompany_idAsString() {
        return String.format("%d", company_id);
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getSport_id() {
        return sport_id;
    }

    public String getSport_idAsString() {
        return String.format("%d", sport_id);
    }

    public void setSport_id(int sport_id) {
        this.sport_id = sport_id;
    }

    public Court getCourt() {
        return court;
    }

    public String getCourtdAsString() {
        return String.format("%d", court);
    }

    public void setCourt(Court court) {
        this.court = court;
    }
}
