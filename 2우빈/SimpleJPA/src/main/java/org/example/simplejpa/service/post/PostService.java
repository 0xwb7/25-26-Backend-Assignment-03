package org.example.simplejpa.service.post;

import lombok.RequiredArgsConstructor;
import org.example.simplejpa.domain.post.Post;
import org.example.simplejpa.domain.user.User;
import org.example.simplejpa.dto.post.request.PostCreateRequest;
import org.example.simplejpa.dto.post.request.PostUpdateRequest;
import org.example.simplejpa.dto.post.response.PostResponse;
import org.example.simplejpa.exception.BadRequestException;
import org.example.simplejpa.exception.ErrorMessage;
import org.example.simplejpa.exception.NotFoundException;
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
    public PostResponse savePost(PostCreateRequest postCreateRequest) {
        User user = userRepository.findById(postCreateRequest.getUserId())
                .orElseThrow(() -> new BadRequestException(ErrorMessage.WRONG_USER_ID));

        Post post = Post.builder()
                .user(user)
                .title(postCreateRequest.getTitle())
                .content(postCreateRequest.getContent())
                .build();

        postRepository.save(post);

        return PostResponse.postInfo(post);
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.WRONG_POST_ID));

        return PostResponse.postInfo(post);
    }

    @Transactional
    public PostResponse updatePost(Long postId, PostUpdateRequest postUpdateRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.WRONG_POST_ID));

        post.updatePost(postUpdateRequest.getTitle(), postUpdateRequest.getContent());

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
                .orElseThrow(() -> new NotFoundException(ErrorMessage.WRONG_POST_ID));

        postRepository.delete(post);
    }
}
