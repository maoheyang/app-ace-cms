package com.ace.cms.service.impl;

import com.ace.cms.dto.ContentDto;
import com.ace.cms.entity.Page;
import com.ace.cms.entity.content.Content;
import com.ace.cms.entity.user.User;
import com.ace.cms.mapper.ContentMapper;
import com.ace.cms.mapper.ContentPictureMapper;
import com.ace.cms.mapper.UserMapper;
import com.ace.cms.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private ContentPictureMapper contentPictureMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Content> getListByChannelId(int channelId, int start, int pageSize) {
        Page page = new Page(start,pageSize);
        //TODO 列表后期需要添加缓存
        List<ContentDto> list = contentMapper.getListByChannelId(channelId,page.getStartRow(),page.getPageCount());

        List<Content> result = new ArrayList<>();
        //TODO 此处需要添加缓存
        for(ContentDto contentDto:list) {
            Content content = new Content();
            content.setCommentNum(contentDto.getCommentsDay());
            content.setTitle(contentDto.getTitle());
            content.setId(contentDto.getContentId());
            content.setPicArr(contentPictureMapper.getPicArr(content.getId()));
            User user = userMapper.getUserInfo(contentDto.getAuthorId());
            if(Objects.equals(user , null)) {
                user = new User();
            }
            if(!Objects.equals(user, null)) {
                //TODO 缺乏作者标签
                List userTag = new ArrayList<>();
                user.setUserTag(userTag);
                if(contentDto.getAuthorId() == 0) {
                    user.setAnonymous(true);
                }
            }
            content.setUser(user);
            result.add(content);

        }
        return result;
    }

}
