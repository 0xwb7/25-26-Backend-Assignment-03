package org.example.simplejpa.service.post;

import lombok.RequiredArgsConstructor;
import org.example.simplejpa.domain.post.Post;
import org.example.simplejpa.domain.user.User;
import org.example.simplejpa.dto.post.request.PostRequest;
import org.example.simplejpa.dto.post.response.PostResponse;
import org.example.simplejpa.exception.BadRequestException;
import org.example.simplejpa.exception.ErrorMessage;
import org.example.simplejpa.exception.PostException;
import org.example.simplejpa.repository.post.PostRepository;
import org.example.simplejpa.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public PostResponse savePost(PostRequest postRequest) {
        User user = userRepository.findById(postRequest.getUserId())
                .orElseThrow(() -> new PostException(ErrorMessage.WRONG_USER_ID));

        Post post = Post.builder()
                .user(user)
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .build();

        postRepository.save(post);

        return PostResponse.postInfo(post);
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(ErrorMessage.WRONG_POST_ID));

        return PostResponse.postInfo(post);
    }

    @Transactional
    public PostResponse updatePost(Long postId, PostRequest postRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(ErrorMessage.WRONG_POST_ID));

        User user = userRepository.findById(postRequest.getUserId())
                .orElseThrow(() -> new BadRequestException(ErrorMessage.WRONG_USER_ID));

        post.updatePost(user, postRequest.getTitle(), postRequest.getContent());

        return PostResponse.postInfo(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostResponse::postInfo)
                .toList();
    }

    @Transactional
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(ErrorMessage.WRONG_POST_ID));

        postRepository.delete(post);
    }
}
