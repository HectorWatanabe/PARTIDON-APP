package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Desarrollo Infobox on 24/05/2017.
 */

public class Match {

    public enum Type{
        None(-1), Basket(1), Soccer(2), Tennis(3);
        private int type;
        Type(int type) {
            this.type = type;
        }
        public int getType() { return type; }
        public static Type from(int type){
            switch (type){
                case 1: return Soccer;
                case 2: return Basket;
                case 3: return Tennis;
                default: return None;
            }
        }
    }

    @SerializedName("id")
    private int idMatch;
    @SerializedName("name")
    private String title;
    @SerializedName("team_red_id")
    private int teamOne;
    @SerializedName("team_blue_id")
    private int teamTwo;
    @SerializedName("sport_id")
    private int sport;
    @SerializedName("address")
    private String location;
    @SerializedName("match_date")
    private String date;
    @SerializedName("icon_image")
    private String icon_image;
    @SerializedName("district")
    private String district;
    @SerializedName("author_id")
    private int author_id;
    @SerializedName("team_red")
    private Team team_red;
    @SerializedName("team_blue")
    private Team team_blue;



    public Match() {
    }

    public Match(int idMatch, String title, int teamOne, int teamTwo, int sport, String location, String date, String icon_image, String district, int author_id, Team team_red, Team team_blue) {
        this.idMatch = idMatch;
        this.title = title;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.sport = sport;
        this.location = location;
        this.date = date;
        this.icon_image = icon_image;
        this.district = district;
        this.author_id = author_id;
        this.team_red = team_red;
        this.team_blue = team_blue;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public String getIdMatchAsString() {
        return String.format("%d", idMatch);
    }

    public Match setIdMatch(int idMatch) {
        this.idMatch = idMatch;
        return this;
    }

    public int getTeamOne() {
        return teamOne;
    }

    public String getTeamOneAsString() {
        return String.format("%d", teamOne);
    }


    public void setTeamOne(int teamOne) {
        this.teamOne = teamOne;
    }

    public int getTeamTwo() {
        return teamTwo;
    }

    public String getTeamTwoAsString() {
        return String.format("%d", teamTwo);
    }

    public void setTeamTwo(int teamTwo) {
        this.teamTwo = teamTwo;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public String getAuthor_idAsString() {
        return String.format("%d", author_id);
    }


    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getSport() {
        return sport;
    }


    public String getSportAsString() {
        return String.format("%d", sport);
    }

    public Match setSport(int sport) {
        this.sport = sport;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Type getType(){
        return Type.from(sport);
    }

    public String getIcon_image() {
        return icon_image;
    }

    public void setIcon_image(String icon_image) {
        this.icon_image = icon_image;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


    public Team getTeam_red() {
        return team_red;
    }

    public void setTeam_red(Team team_red) {
        this.team_red = team_red;
    }

    public Team getTeam_blue() {
        return team_blue;
    }

    public void setTeam_blue(Team team_blue) {
        this.team_blue = team_blue;
    }
}
