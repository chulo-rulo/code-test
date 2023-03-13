package com.capgemini.blablacap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.blablacap.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
    @Query(value = "SELECT * FROM Comment ORDER BY datetime DESC FETCH FIRST 5 ROWS ONLY", nativeQuery = true)
    List<Comment> lastComments();
}
