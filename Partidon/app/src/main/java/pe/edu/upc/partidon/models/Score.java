package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hector on 03/06/2017.
 */

public class Score {

    @SerializedName("id")
    int user_id;
    @SerializedName("match_id")
    int match_id;
    @SerializedName("score_team_red")
    int home_score;
    @SerializedName("score_team_blue")
    int away_score;

    public Score() {
    }

    public Score(int user_id, int match_id, int home_score, int away_score) {
        this.user_id = user_id;
        this.match_id = match_id;
        this.home_score = home_score;
        this.away_score = away_score;
    }

    public int getUser_id() {
        return user_id;
    }
    public String getUser_idAsString() {
        return String.format("%d", user_id);
    }
    public Score setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public int getMatch_id() {
        return match_id;
    }
    public String getMatch_idAsString() {
        return String.format("%d", match_id);
    }

    public Score setMatch_id(int match_id) {
        this.match_id = match_id;
        return this;
    }

    public int getHome_score() {
        return home_score;
    }
    public String getHome_scoreAsString() {
        return String.format("%d", home_score);
    }

    public Score setHome_score(int home_score) {
        this.home_score = home_score;
        return this;
    }

    public int getAway_score() {
        return away_score;
    }
    public String getAway_scoreAsString() {
        return String.format("%d", away_score);
    }
    public Score setAway_score(int away_score) {
        this.away_score = away_score;
        return this;
    }


}
