package com.capgemini.blablacap.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.blablacap.models.Comment;
import com.capgemini.blablacap.models.CommentWithName;
import com.capgemini.blablacap.models.User;
import com.capgemini.blablacap.services.CommentService;
import com.capgemini.blablacap.services.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/comments")
public class CommentREST {
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("/last")
    ResponseEntity<List<CommentWithName>> getLastComments() {
        List<Comment>comments = commentService.lastComments();
        User user = new User();
        CommentWithName commentWithName;
        List<CommentWithName>resultado = new ArrayList();
        for (Comment comment : comments) {
            user = comment.getUser();
            if(user!=null) {
                 commentWithName  = new CommentWithName(comment.getText(), user.getName()+" "+user.getSurname());
                 resultado.add(commentWithName);
            }
        }

        if(resultado.isEmpty()){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } else {
            return ResponseEntity.ok(resultado);
        }

    }
    
}
