package org.example.simplejpa.exception;

public enum ErrorMessage {
    WRONG_NAME_INPUT("잘못된 이름입니다."),
    WRONG_EMAIL_INPUT("잘못된 이메일입니다."),
    USER_REQUIRED("유저 정보는 비어있을 수 없습니다."),
    TITLE_REQUIRED("글 제목은 비어있을 수 없습니다."),
    CONTENT_REQUIRED("글 내용은 비어있을 수 없습니다."),
    WRONG_USER_ID("존재하지 않는 유저 ID입니다."),
    WRONG_POST_ID("존재하지 않는 포스트입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
