package com.ace.cms.service;

import com.ace.cms.entity.comment.Comment;
import com.ace.cms.entity.content.Content;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentById(Long id, int start, int pageSize);

    void add(Long id, Long userId, Long parentCommentId, String text);

}
