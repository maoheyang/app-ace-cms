package com.ace.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long commentId;
    private Long contentId;
    private String text;
    private Long commentUserId;
    private Date createTime;
    private Date replyTime;
    private int replyCount;
    private String reply;

    private Long siteId;
    private Long parentId;
}
