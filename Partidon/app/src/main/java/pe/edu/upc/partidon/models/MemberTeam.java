package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hector on 30/06/2017.
 */

public class MemberTeam {
    @SerializedName("id")
    int id;
    @SerializedName("role")
    String role;
    @SerializedName("team_id")
    int team_id;
    @SerializedName("player_id")
    int player_id;
    @SerializedName("player")
    Player player;


    public MemberTeam() {
    }

    public MemberTeam(int id, String role, int team_id, int player_id, Player player) {
        this.id = id;
        this.role = role;
        this.team_id = team_id;
        this.player_id = player_id;
        this.player = player;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public int getPlayer_id() {
        return player_id;
    }

    public String getPlayer_idAsString() {
        return String.format("%d", player_id);
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
