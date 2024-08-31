package com.example.ReservationSystems.controller;

import com.example.ReservationSystems.model.Comment;
import com.example.ReservationSystems.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{reservationId}")
    public Comment getComment(@PathVariable("reservationId") Integer reservationId) {
        return commentService.getComment(reservationId);
    }

    @PostMapping
    public Comment saveComment(@RequestBody Comment comment) throws Exception {
        return commentService.saveComment(comment);
    }

}
