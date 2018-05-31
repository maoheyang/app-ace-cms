package com.ace.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {

    private Long contentId;
    private Long authorId;
    private String title;
    private int commentsDay;

}
