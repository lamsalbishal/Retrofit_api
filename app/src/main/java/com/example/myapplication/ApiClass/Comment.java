package com.example.myapplication.ApiClass;

public class Comment {
    private String comment;

    private String commentid;

    private String postid;

    public Comment(String comment, String commentid, String postid) {
        this.comment = comment;
        this.commentid = commentid;
        this.postid = postid;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentid() {
        return commentid;
    }

    public String getPostid() {
        return postid;
    }
}
