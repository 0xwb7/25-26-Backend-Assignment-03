package org.example.simplejpa.dto.post.request;

import lombok.Getter;

@Getter
public class PostRequest {
    private Long userId;
    private String title;
    private String content;
}
