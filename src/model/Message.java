package model;

public class Message {

    private String date;
    private String time;
    private String username;
    private String message;

    public Message() {
    }

    public Message(String date, String time, String username, String message) {
        this.date = date;
        this.time = time;
        this.username = username;
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}
