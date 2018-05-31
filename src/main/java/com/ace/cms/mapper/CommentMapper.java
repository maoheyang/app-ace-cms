package com.ace.cms.mapper;

import com.ace.cms.dto.CommentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

	List<CommentDto> getCommentByContentId(@Param("contentId") Long contentId,
										   @Param("start") Integer start, @Param("pageSize") Integer pageSize);

	int insert(CommentDto dto);
}
