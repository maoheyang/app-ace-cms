package com.ace.cms.mapper;

import com.ace.cms.entity.user.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	User getUserInfo(@Param("authorId") Long authorId);


}
