package com.example.ReservationSystems.service;

import com.example.ReservationSystems.model.Comment;

public interface CommentService {

    Comment getComment(Integer reservationId);
    Comment saveComment(Comment comment) throws Exception;

}
