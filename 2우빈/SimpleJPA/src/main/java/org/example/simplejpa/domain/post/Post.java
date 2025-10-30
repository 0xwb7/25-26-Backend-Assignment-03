package org.example.simplejpa.domain.post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.simplejpa.domain.user.User;
import org.example.simplejpa.dto.post.request.PostRequest;
import org.example.simplejpa.exception.ErrorCode;
import org.example.simplejpa.exception.PostException;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 100, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Builder
    public Post(User user, String title, String content) {
        validate(user, title, content);

        this.user = user;
        this.title = title;
        this.content = content;
    }

    public void updatePost(User user, String title, String content) {
        validate(user, title, content);

        this.user = user;
        this.title = title;
        this.content = content;
    }

    private void validate(User user, String title, String content) {
        if (user == null) {
            throw new PostException(ErrorCode.USER_REQUIRED);
        }

        if (title == null || title.isBlank()) {
            throw new PostException(ErrorCode.TITLE_REQUIRED);
        }

        if (content == null || content.isBlank()) {
            throw new PostException(ErrorCode.CONTENT_REQUIRED);
        }
    }
}
