package org.example.musicjpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MusicException extends IllegalArgumentException {
  public MusicException(ErrorCode errorcode) {
    super(errorcode.message());
  }
}
