package org.example.simplejpa.dto.user.response;

import lombok.Builder;
import lombok.Getter;
import org.example.simplejpa.domain.user.User;

@Getter
@Builder
public class UserResponse {
    private Long userId;
    private String username;
    private String email;

    public static UserResponse userInfo(User user) {
        return UserResponse.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
