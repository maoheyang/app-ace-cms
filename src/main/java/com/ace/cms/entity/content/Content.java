package com.ace.cms.entity.content;

import com.ace.cms.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    private User user;
    //图片
    private List<PicArr> picArr;
    //标题
    private String title;
    //内容ID
    private Long id;
    //评论数
    private Integer commentNum;
}
