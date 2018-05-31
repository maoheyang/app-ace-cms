package com.ace.cms.service.impl;

import com.ace.cms.dto.CommentDto;
import com.ace.cms.dto.CommentExtDto;
import com.ace.cms.dto.ContentDto;
import com.ace.cms.entity.Page;
import com.ace.cms.entity.comment.Comment;
import com.ace.cms.entity.content.Content;
import com.ace.cms.entity.user.User;
import com.ace.cms.mapper.*;
import com.ace.cms.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CommentExtMapper commentExtMapper;

    @Autowired
    private ContentMapper contentMapper;

    @Override
    public List<Comment> getCommentById(Long id, int start, int pageSize) {
        Page page = new Page(start,pageSize);
        List<CommentDto> list = commentMapper.getCommentByContentId(id, page.getStartRow(), page.getPageCount());

        List<Comment> result = new ArrayList<>();
        for(CommentDto commentDto : list) {
            Comment comment = new Comment();
            comment.setCommentId(commentDto.getCommentId());
            comment.setContentId(commentDto.getContentId());
            comment.setText(commentDto.getText());
            comment.setCreateTime(commentDto.getCreateTime());
            comment.setReplyTime(commentDto.getReplyTime());
            comment.setReply(commentDto.getReply());
            comment.setReplyCount(commentDto.getReplyCount());
            User user = userMapper.getUserInfo(commentDto.getCommentUserId());
            if(Objects.equals(user, null)) {
                user = new User();
            }

            if(!Objects.equals(user, null)) {
                //TODO 缺乏作者标签
                List userTag = new ArrayList<>();
                user.setUserTag(userTag);
                if(commentDto.getCommentUserId() == 0) {
                    user.setAnonymous(true);
                }
            }

            comment.setUser(user);
            result.add(comment);

        }
        return result;
    }

    @Override
    public void add(Long id, Long userId, Long parentCommentId, String text) {
        //内容数目加1
        contentMapper.addComments(id);

        //添加评论表
        CommentDto dto = new CommentDto();
        dto.setSiteId(1l);
        dto.setCommentUserId(userId);
        dto.setContentId(id);
        dto.setParentId(parentCommentId);
        commentMapper.insert(dto);

        //添加评论内容表
        CommentExtDto commentExtDto = new CommentExtDto();
        commentExtDto.setCommentId(dto.getCommentId());
        commentExtDto.setText(text);
        commentExtMapper.insert(commentExtDto);


    }
}
