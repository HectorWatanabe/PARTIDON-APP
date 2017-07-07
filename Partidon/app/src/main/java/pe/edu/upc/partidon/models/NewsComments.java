package pe.edu.upc.partidon.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hector on 20/05/2017.
 */

public class NewsComments {


    @SerializedName("id")
    private int id;
    @SerializedName("author_id")
    private int author_id;
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("match_id")
    private int match_id;
    @SerializedName("team_id")
    private int team_id;
    @SerializedName("comment")
    private String Comment;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("author")
    private User user;

    public NewsComments() {
    }

    public NewsComments(int id, int author_id, int user_id, int match_id, int team_id, String comment, String created_at, User user) {
        this.id = id;
        this.author_id = author_id;
        this.user_id = user_id;
        this.match_id = match_id;
        this.team_id = team_id;
        Comment = comment;
        this.created_at = created_at;
        this.user = user;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
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

    public int getAuthor_id() {
        return author_id;
    }

    public String getAuthor_idAsString() {
        return String.format("%d", author_id);
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getUser_id() {
        return user_id;
    }


    public String getUser_idAsString() {
        return String.format("%d", user_id);
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMatch_idAsString() {
        return String.format("%d", match_id);
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
