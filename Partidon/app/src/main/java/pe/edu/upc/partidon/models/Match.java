package pe.edu.upc.partidon.models;

import java.util.Date;

/**
 * Created by Desarrollo Infobox on 24/05/2017.
 */

public class Match {

    private int idMatch;
    private String teamOne;
    private String teamTwo;
    private int sport;
    private int availableSite;

    public Match() {
    }

    public Match(int idMatch, String teamOne, String teamTwo, int sport, int availableSite) {
        this.idMatch = idMatch;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.sport = sport;
        this.availableSite = availableSite;
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

    public String getTeamOne() {
        return teamOne;
    }

    public Match setTeamOne(String teamOne) {
        this.teamOne = teamOne;
        return this;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public Match setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
        return this;
    }

    public int getSport() {
        return sport;
    }

    public Match setSport(int sport) {
        this.sport = sport;
        return this;
    }

    public int getAvailableSite() {
        return availableSite;
    }
    public String getAvailableSiteAsString() {
        return String.format("%d", availableSite);
    }

    public Match setAvailableSite(int availableSite) {
        this.availableSite = availableSite;
        return this;
    }
}
