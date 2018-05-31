package com.ace.cms.entity.comment;

import com.ace.cms.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long commentId;
    private Long contentId;
    private String text;
    private String reply;
    private User user;
    private Date createTime;
    private Date replyTime;
    private int replyCount;

}
