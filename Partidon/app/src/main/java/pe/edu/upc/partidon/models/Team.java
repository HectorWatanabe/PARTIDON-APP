package pe.edu.upc.partidon.models;

/**
 * Created by Desarrollo Infobox on 24/05/2017.
 */

public class Team {

    private int idTeam;
    private String teamName;
    private int sport;
    private int availableSiteTeam;

    public Team() {
    }

    public Team(int idTeam, String teamName, int sport, int availableSiteTeam) {
        this.idTeam = idTeam;
        this.teamName = teamName;
        this.sport = sport;
        this.availableSiteTeam = availableSiteTeam;
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
}
