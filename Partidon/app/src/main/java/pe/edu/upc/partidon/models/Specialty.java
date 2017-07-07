package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hector on 06/07/2017.
 */

public class Specialty {

    @SerializedName("id")
    int id;
    @SerializedName("player_id")
    int player_id;
    @SerializedName("sport_id")
    int sport;

    public Specialty() {
    }

    public Specialty(int id, int player_id, int sport) {
        this.id = id;
        this.player_id = player_id;
        this.sport = sport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }
}
