package org.example.simplejpa.util;

import org.example.simplejpa.domain.user.User;
import org.example.simplejpa.exception.BadRequestException;
import org.example.simplejpa.exception.ErrorMessage;
import org.example.simplejpa.exception.PostException;

public class Validator {

    public static void validateUser(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new BadRequestException(ErrorMessage.WRONG_NAME_INPUT);
        }

        if (email == null || email.isBlank()) {
            throw new BadRequestException(ErrorMessage.WRONG_EMAIL_INPUT);
        }
    }

    public static void validatePost(User user, String title, String content) {
        if (user == null) {
            throw new BadRequestException(ErrorMessage.USER_REQUIRED);
        }

        if (title == null || title.isBlank()) {
            throw new BadRequestException(ErrorMessage.TITLE_REQUIRED);
        }

        if (content == null || content.isBlank()) {
            throw new BadRequestException(ErrorMessage.CONTENT_REQUIRED);
        }
    }
}
