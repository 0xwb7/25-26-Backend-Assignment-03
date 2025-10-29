package org.example.simplejpa.service.user;

import lombok.RequiredArgsConstructor;
import org.example.simplejpa.domain.user.User;
import org.example.simplejpa.dto.user.request.UserRequest;
import org.example.simplejpa.dto.user.response.UserResponse;
import org.example.simplejpa.exception.ErrorCode;
import org.example.simplejpa.exception.PostException;
import org.example.simplejpa.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse saveUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getUsername())
                .email(userRequest.getEmail())
                .build();

        userRepository.save(user);

        return UserResponse.userInfo(user);
    }

    @Transactional(readOnly = true)
    public UserResponse getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new PostException(ErrorCode.WRONG_USER_ID));

        return UserResponse.userInfo(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::userInfo)
                .toList();
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new PostException(ErrorCode.WRONG_USER_ID));

        userRepository.delete(user);
    }
}
