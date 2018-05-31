package com.ace.cms.controller;

import com.ace.cms.entity.Response;
import com.ace.cms.entity.comment.Comment;
import com.ace.cms.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/comment", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
public class CommentController extends AbstractController{

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/list")
    public Response<List<Comment>> get(@RequestParam(value = "jsessionId", required = false) String jsessionId,
                                       @RequestParam(value = "id", required = false) Long id,
                                       @RequestParam(value = "first", required = false, defaultValue = "1") int first,
                                       @RequestParam(value = "count", required = false, defaultValue = "10") int count) {
        List<Comment> result = commentService.getCommentById(id,first,count);
        return new Response<>(result);

    }

    @RequestMapping(value = "/add")
    public Response<Boolean> add(@RequestParam(value = "jsessionId", required = false) String jsessionId,
                                        @RequestParam(value = "id", required = false) Long id,
                                        @RequestParam(value = "userId", required = false) Long userId,
                                        @RequestParam(value = "parentCommentId", required = false, defaultValue="0") Long parentCommentId,
                                        @RequestParam(value = "text", required = false, defaultValue = "") String text) {
        commentService.add(id,userId,parentCommentId,text);
        return new Response<>(true);
    }




}


