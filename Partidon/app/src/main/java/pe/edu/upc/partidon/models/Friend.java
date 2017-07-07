package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hector on 30/06/2017.
 */

public class Friend {
    @SerializedName("id")
    int id;
    @SerializedName("player_id")
    int player_id;
    @SerializedName("friend_id")
    int friend_id;
    @SerializedName("friend")
    Player player;

    public Friend() {
    }

    public Friend(int id, int player_id, int friend_id, Player player) {
        this.id = id;
        this.player_id = player_id;
        this.friend_id = friend_id;
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

    public int getPlayer_id() {
        return player_id;
    }
    public String getPlayer_idAsString() {
        return String.format("%d", player_id);
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getFriend_id() {
        return friend_id;
    }
    public String getFriend_idAsString() {
        return String.format("%d", friend_id);
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
