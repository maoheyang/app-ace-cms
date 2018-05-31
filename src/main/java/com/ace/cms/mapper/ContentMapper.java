package com.ace.cms.mapper;

import com.ace.cms.dto.ContentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentMapper {

	List<ContentDto> getListByChannelId(@Param("channelId") Integer channelId, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

	int addComments(@Param("contentId") Long contentId);
}
