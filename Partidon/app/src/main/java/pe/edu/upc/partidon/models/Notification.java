package pe.edu.upc.partidon.models;

/**
 * Created by user on 15/06/2017.
 */

public class Notification {


    private String userName;
    private String userNotification;
    private String imageUser;

    public Notification() {
    }

    public Notification(String userName, String userNotification, String imageUser) {
        this.userName = userName;
        this.userNotification = userNotification;
        this.imageUser = imageUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNotification() {
        return userNotification;
    }

    public void setUserNotification(String userNotification) {
        this.userNotification = userNotification;
    }

    public String getImageUser() {
        return imageUser;
    }

    public void setImageUser(String imageUser) {
        this.imageUser = imageUser;
    }
}
