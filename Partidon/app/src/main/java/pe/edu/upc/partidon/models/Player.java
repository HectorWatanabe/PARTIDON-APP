package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hector on 11/06/2017.
 */

public class Player {

    @SerializedName("id")
    int id_player;
    @SerializedName("score")
    int score;
    @SerializedName("user")
    User user;

    public Player() {
    }

    public Player(int id_player, int score, User user) {
        this.id_player = id_player;
        this.score = score;
        this.user = user;
    }

    public int getId_player() {
        return id_player;
    }

    public String getId_playerAsString() {
        return String.format("%d", id_player);
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
    }

    public int getScore() {
        return score;
    }


    public String getScoreAsString() {
        return String.format("%d", score);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
