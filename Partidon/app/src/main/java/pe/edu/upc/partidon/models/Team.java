package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Desarrollo Infobox on 24/05/2017.
 */

public class Team {

    public enum Type{
        None(-1), Basket(1), Soccer(2), Tennis(3);
        private int type;
        Type(int type) {
            this.type = type;
        }
        public int getType() { return type; }
        public static Team.Type from(int type){
            switch (type){
                case 1: return Soccer;
                case 2: return Basket;
                case 3: return Tennis;
                default: return None;
            }
        }
    }


    @SerializedName("id")
    private int idTeam;
    @SerializedName("name")
    private String teamName;
    @SerializedName("sport_id")
    private int sport;
    @SerializedName("players")
    private int availableSiteTeam;
    @SerializedName("icon_image")
    private String icon_image;
    @SerializedName("author_id")
    private int author_id;

    public Team() {
    }

    public Team(int idTeam, String teamName, int sport, int availableSiteTeam, String icon_image, int author_id) {
        this.idTeam = idTeam;
        this.teamName = teamName;
        this.sport = sport;
        this.availableSiteTeam = availableSiteTeam;
        this.icon_image = icon_image;
        this.author_id = author_id;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public String getIdTeamAsString() {
        return String.format("%d", idTeam);
    }

    public Team setIdTeam(int idTeam) {
        this.idTeam = idTeam;
        return  this;
    }

    public String getTeamName() {
        return teamName;
    }

    public Team setTeamName(String teamName) {
        this.teamName = teamName;
        return  this;
    }

    public int getSport() {
        return sport;
    }
    public String getSportAsString() {
        return String.format("%d", sport);
    }

    public Team setSport(int sport) {
        this.sport = sport;
        return  this;
    }

    public int getAvailableSiteTeam() {
        return availableSiteTeam;
    }

    public String getAvailableSiteTeamAsString() {
        return String.format("%d", availableSiteTeam);
    }

    public Team setAvailableSiteTeam(int availableSiteTeam) {
        this.availableSiteTeam = availableSiteTeam;
        return  this;
    }
    public Team.Type getType(){
        return Team.Type.from(sport);
    }

    public String getIcon_image() {
        return icon_image;
    }

    public void setIcon_image(String icon_image) {
        this.icon_image = icon_image;
    }


    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_idAsString() {
        return String.format("%d", author_id);
    }
}
