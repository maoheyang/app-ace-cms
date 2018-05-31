package com.ace.cms.service;

import com.ace.cms.BaseServiceTest;
import com.ace.cms.entity.comment.Comment;
import com.ace.cms.entity.content.Content;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContentServiceTest extends BaseServiceTest {

    @Autowired
    private ContentService contentService;

    @Autowired
    private CommentService commentService;

    @Test
    public void test() {

        List<Content> result = contentService.getListByChannelId(75, 1 ,10);

        System.out.println(result);
    }

    @Test
    public void test2() {
        List<Comment> result = commentService.getCommentById(200l,1,10);
        System.out.println(result);
    }

    @Test
    public void test3() {
        commentService.add(2l,0l,30L,"测试");
    }

}
