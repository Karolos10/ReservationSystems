package com.example.ReservationSystems.repository;

import com.example.ReservationSystems.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(
            nativeQuery = true,
            value = "select c.comment_id, c.date_time_comments, c.rating, c.reservation_id, c.user_id " +
                    "from bookingsystems.comments c " +
                    "where c.reservation_id = :reservationId")
    Comment findByReservationId(@Param("reservationId") Integer reservationId);
}
