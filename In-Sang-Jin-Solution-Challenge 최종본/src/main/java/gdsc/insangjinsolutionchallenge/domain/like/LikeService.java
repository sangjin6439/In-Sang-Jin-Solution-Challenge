package gdsc.insangjinsolutionchallenge.domain.like;

import gdsc.insangjinsolutionchallenge.domain.post.Post;
import gdsc.insangjinsolutionchallenge.domain.post.PostRepository;
import gdsc.insangjinsolutionchallenge.domain.post.PostService;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import gdsc.insangjinsolutionchallenge.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final PostService postService;
    private final UserRepository userRepository;

    @Transactional
    public void addLike(Long userId, Long postId){
        User userInfo = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("올바른 유저 정보를 입력해 주세요."));
        Post post = postService.findPostDao(postId);
        if (!likeRepository.existsByUserAndPost(userInfo, post)){
            post.addLikeCount(post.getLikeCount()+1);
            Like like =Like.builder()
                    .user(userInfo)
                    .post(post)
                    .build();
            likeRepository.save(like);
        } else {
            post.addLikeCount(post.getLikeCount()-1);
            likeRepository.deleteByUserAndPost(userInfo,post);
        }
    }



}
