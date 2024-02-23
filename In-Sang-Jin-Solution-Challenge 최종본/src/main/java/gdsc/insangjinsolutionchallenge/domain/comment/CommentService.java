package gdsc.insangjinsolutionchallenge.domain.comment;

import gdsc.insangjinsolutionchallenge.domain.post.Post;
import gdsc.insangjinsolutionchallenge.domain.post.PostRepository;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import gdsc.insangjinsolutionchallenge.domain.user.UserRepository;
import gdsc.insangjinsolutionchallenge.global.exception.ApplicationErrorException;
import gdsc.insangjinsolutionchallenge.global.exception.ApplicationErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public String save(Long userId, Long postId, RequestCommentDto requestCommentDto) {
        Post post =postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("없는 게시물입니다."));
        User userInfo = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("없는 유저입니다."));
         Comment comment = Comment.builder()
                .content(requestCommentDto.getContent())
                .post(post)
                .user(userInfo)
                .build();
        commentRepository.save(comment);
       return "댓글이 저장됐습니다.";
    }

    @Transactional(readOnly = true)
    public List<ResponseCommentDto> findAll(Long postId){
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        List<ResponseCommentDto> commentDtos = comments.stream()
                .map(comment -> ResponseCommentDto.builder()
                        .id(comment.getId())
                        .userName(comment.getUser().getName())
                        .userLevel(comment.getUser().getLevel())
                        .content(comment.getContent())
                        .createAt(comment.getCreateAt())
                        .build())
                .toList();

        return commentDtos;
    }

    @Transactional
    public String delete(Long userId, Long id) {
        Long authorId = Long.valueOf(String.valueOf(findCommentDao(id).getUser().getId()));
        if(!authorId.equals(userId)){
            throw new ApplicationErrorException(ApplicationErrorType.UNAUTHORIZED,"권한이 없는 사용자입니다.");
        }
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("다시 확인해주세요"));
        commentRepository.delete(comment);
        return "삭제되었습니다.";
    }

    private Comment findCommentDao(Long id){
        return commentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("다시 확인해주세요."));
    }

}
