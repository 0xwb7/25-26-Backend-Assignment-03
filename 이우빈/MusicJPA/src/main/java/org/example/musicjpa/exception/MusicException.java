package org.example.musicjpa.exception;

public class MusicException extends IllegalArgumentException {
  public MusicException(ErrorCode errorcode) {
    super(errorcode.message());
  }
}
