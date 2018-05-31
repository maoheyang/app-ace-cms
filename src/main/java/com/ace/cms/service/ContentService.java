package com.ace.cms.service;

import com.ace.cms.entity.content.Content;

import java.util.List;

public interface ContentService {

    List<Content> getListByChannelId(int channelId, int start, int pageSize);

}
