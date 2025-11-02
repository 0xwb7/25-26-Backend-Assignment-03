package org.example.simplejpa.dto.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "유저 이름은 비어있을 수 없습니다.")
    private String username;

    @NotBlank(message = "유저 이메일은 비어있을 수 없습니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
}
