/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Spotify.Controllers;

import org.Spotify.Models.Comment;
import org.Spotify.Services.CommentService;

/**
 *
 * @author Yo
 */
public class CommentController {
    private CommentService commentService;
    //methods from service
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    public void insertComment(Comment comment) {
        commentService.addComment(comment);
    }
    public void showComment(String idComment) {
        commentService.readComment(idComment);
    }
    public void deleteComment(Comment comment) {
        commentService.deleteComment(comment);
    }
    public void updateComment(Comment comment) {
        commentService.updateComment(comment);
    }
}
