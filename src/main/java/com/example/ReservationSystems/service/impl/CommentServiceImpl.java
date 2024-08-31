package com.example.ReservationSystems.service.impl;

import com.example.ReservationSystems.model.Comment;
import com.example.ReservationSystems.repository.CommentRepository;
import com.example.ReservationSystems.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment getComment(Integer reservationId) {
        Comment commentResult = commentRepository.findByReservationId(reservationId);
        if (commentResult != null) {
            return commentResult;
        }
        return new Comment();
    }

    @Override
    public Comment saveComment(Comment comment) throws Exception {
        Comment commentResult = commentRepository.findByReservationId(comment.getReservation().getReservationId());
        if (commentResult != null) {
            throw new Exception("Ya se ha calificado la reserva");
        } else {
            commentResult = commentRepository.save(comment);
            return commentResult;
        }
    }

}
