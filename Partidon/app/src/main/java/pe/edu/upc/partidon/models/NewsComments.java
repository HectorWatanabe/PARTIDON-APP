package pe.edu.upc.partidon.models;

/**
 * Created by Hector on 20/05/2017.
 */

public class NewsComments {

    private String nameUser;
    private String Comment;
    private int likes;

    public NewsComments() {
    }

    public NewsComments(String nameUser, String comment, int likes) {
        this.nameUser = nameUser;
        Comment = comment;
        this.likes = likes;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
