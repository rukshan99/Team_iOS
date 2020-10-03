package com.app.getsettravel;

public class FeedbackV {

    private int id;
    private String comment,Fmail;

    public FeedbackV(){

    }

    public FeedbackV(int id, String comment, String fmail) {
        this.id = id;
        this.comment = comment;
        Fmail = fmail;
    }

    public FeedbackV(String comment, String fmail) {
        this.comment = comment;
        Fmail = fmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFmail() {
        return Fmail;
    }

    public void setFmail(String fmail) {
        Fmail = fmail;
    }
}
