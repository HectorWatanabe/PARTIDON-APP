package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 15/06/2017.
 */

public class Notification {


    @SerializedName("id")
    private int id;
    @SerializedName("player_id")
    private int player_id;
    @SerializedName("match_id")
    private int match_id;
    @SerializedName("team_id")
    private int team_id;
    @SerializedName("status")
    private String userNotification;
    @SerializedName("player_tarjet")
    private int player_tarjet;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("team")
    private Team team;
    @SerializedName("match")
    private Match match;
    @SerializedName("player")
    private Player player;

    public Notification() {
    }

    public Notification(int id, int player_id, int match_id, int team_id, String userNotification, int player_tarjet, String created_at, Team team, Match match, Player player) {
        this.id = id;
        this.player_id = player_id;
        this.match_id = match_id;
        this.team_id = team_id;
        this.userNotification = userNotification;
        this.player_tarjet = player_tarjet;
        this.created_at = created_at;
        this.team = team;
        this.match = match;
        this.player = player;
    }

    public String getUserNotification() {
        return userNotification;
    }

    public void setUserNotification(String userNotification) {
        this.userNotification = userNotification;
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

    public int getPlayer_id() {
        return player_id;
    }

    public String getPlayer_idAsString() {
        return String.format("%d", player_id);
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public String getMatch_idAsString() {
        return String.format("%d", match_id);
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getPlayer_tarjet() {
        return player_tarjet;
    }

    public String getPlayer_tarjetAsString() {
        return String.format("%d", player_tarjet);
    }


    public void setPlayer_tarjet(int player_tarjet) {
        this.player_tarjet = player_tarjet;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public int getTeam_id() {
        return team_id;
    }

    public String getTeam_idAsString() {
        return String.format("%d", team_id);
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }
}
