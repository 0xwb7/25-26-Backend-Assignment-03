package org.example.simplejpa.dto.post.response;

import lombok.Builder;
import lombok.Getter;
import org.example.simplejpa.domain.post.Post;

@Getter
@Builder
public class PostResponse {
    private Long postId;
    private Long userId;
    private String title;
    private String content;

    public static PostResponse postInfo(Post post) {
        return PostResponse.builder()
                .postId(post.getId())
                .userId(post.getUser().getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
