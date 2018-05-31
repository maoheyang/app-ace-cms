package com.ace.cms.mapper;

import com.ace.cms.entity.content.PicArr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentPictureMapper {

    List<PicArr> getPicArr(@Param("contentId") Long contentId);

}