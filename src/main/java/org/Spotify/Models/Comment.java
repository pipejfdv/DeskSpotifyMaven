
package org.Spotify.Models;

import java.sql.Date;



public class Comment {
    private String idComment;
    private Date dateComment;
    private String contentComment;
    private User userComment;

    public Comment() {
    }

    public Comment(String idComment) {
        this.idComment = idComment;
    }
    
    public Comment(String idComment, Date dateComment, String contentComment, User userComment) {
        this.idComment = idComment;
        this.dateComment = dateComment;
        this.contentComment = contentComment;
        this.userComment = userComment;
    }

    public String getIdComment() {
        return idComment;
    }

    public void setIdComment(String idComment) {
        this.idComment = idComment;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    public String getContentComment() {
        return contentComment;
    }

    public void setContentComment(String contentComment) {
        this.contentComment = contentComment;
    }

    public User getUserComment() {
        return userComment;
    }

    public void setUserComment(User userComment) {
        this.userComment = userComment;
    }
    
    /*public void addComment(User userNickname, String content){
        Comment newCommentUser = new Comment(String.randomString(), Date.now(), content,userNickname);
    }*/
}
