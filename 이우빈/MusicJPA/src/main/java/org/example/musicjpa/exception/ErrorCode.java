package org.example.musicjpa.exception;

public enum ErrorCode {
    WRONG_SINGER_ID("존재하지 않는 가수입니다."),
    WRONG_MUSIC_ID("존재하지 않는 음악입니다."),
    WRONG_NAME_INPUT("잘못된 이름입니다."),
    WRONG_DEBUT_INPUT("잘못된 데뷔년도입니다."),
    WRONG_TITLE_INPUT("잘못된 제목입니다."),
    SINGER_REQUIRED("가수 정보는 비어있을 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
