package org.example.musicjpa.exception;

public enum ErrorCode {
    WRONG_SINGER_ID("존재하지 않는 가수입니다."),
    WRONG_MUSIC_ID("존재하지 않는 음악입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
