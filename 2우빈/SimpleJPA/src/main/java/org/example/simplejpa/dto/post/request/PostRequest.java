package org.example.simplejpa.dto.post.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequest {

    @NotNull(message = "작성자 ID는 필수입니다.")
    private Long userId;

    @NotBlank(message = "글 제목은 비어있을 수 없습니다.")
    private String title;

    @NotBlank(message = "글 내용은 비어있을 수 없습니다.")
    private String content;
}
