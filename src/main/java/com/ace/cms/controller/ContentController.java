package com.ace.cms.controller;

import com.ace.cms.entity.Response;
import com.ace.cms.entity.comment.Comment;
import com.ace.cms.entity.content.Content;
import com.ace.cms.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/content", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
public class ContentController extends AbstractController{

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/list")
    public Response<List<Content>> contentList(@RequestParam(value = "jsessionId", required = false) String jsessionId,
                                               @RequestParam(value = "channelIds", required = false) int channelIds,
                                               @RequestParam(value = "first", required = false, defaultValue = "1") int first,
                                               @RequestParam(value = "count", required = false, defaultValue = "10") int count) {
        List<Content> result = contentService.getListByChannelId(channelIds,first,count);
        return new Response<>(result);

    }

    @RequestMapping(value = "/get")
    public Response<List<Comment>> get(@RequestParam(value = "jsessionId", required = false) String jsessionId,
                                       @RequestParam(value = "id", required = false) Long id,
                                       @RequestParam(value = "first", required = false, defaultValue = "1") int first,
                                       @RequestParam(value = "count", required = false, defaultValue = "10") int count) {
        List<Comment> result = null;
        return new Response<>(result);

    }




}


