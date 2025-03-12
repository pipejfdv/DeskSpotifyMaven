
package org.Spotify.Models;

import java.time.LocalDate;
import java.util.UUID;

public class Comment {
    private UUID idComment;
    private LocalDate dateComment;
    private String contentComment;
    private User userComment;

    public Comment(UUID idComment, LocalDate dateComment, String contentComment, User userComment) {
        this.idComment = idComment;
        this.dateComment = dateComment;
        this.contentComment = contentComment;
        this.userComment = userComment;
    }

    public UUID getIdComment() {
        return idComment;
    }

    public void setIdComment(UUID idComment) {
        this.idComment = idComment;
    }

    public LocalDate getDateComment() {
        return dateComment;
    }

    public void setDateComment(LocalDate dateComment) {
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
    
    public void addComment(User userNickname, String content){
        Comment newCommentUser = new Comment(UUID.randomUUID(), LocalDate.now(), content,userNickname);
    }
}
