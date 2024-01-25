package gdsc.insangjinsolutionchallenge.domain.comment;

import gdsc.insangjinsolutionchallenge.domain.post.Post;
import gdsc.insangjinsolutionchallenge.domain.post.PostRepository;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import gdsc.insangjinsolutionchallenge.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Transactional
    public String save(Long postId,RequestCommentDto requestCommentDto) {
        Post post =postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("없는 게시물입니다."));
        User user =userRepository.findById(requestCommentDto.getUserId()).orElseThrow(()-> new IllegalArgumentException("정확한 유저를 입력하시오"));
        Comment comment = Comment.builder()
                .content(requestCommentDto.getContent())
                .post(post)
                .user(user)
                .build();
        commentRepository.save(comment);
       return "댓글이 저장됐습니다.";
    }

    @Transactional(readOnly = true)
    public List<ResponseCommentDto> findAll(Long postId){
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        List<ResponseCommentDto> commentDtos = new ArrayList<>();

        for (Comment comment : comments) {
            ResponseCommentDto responseCommentDto =ResponseCommentDto.builder()
                    .id(comment.getId())
                    .userName(comment.getUser().getName())
                    .userLevel(comment.getUser().getLevel())
                    .content(comment.getContent())
                    .creatAt(comment.getCreateAt())
                    .build();
            commentDtos.add(responseCommentDto);
        }
        return commentDtos;
    }

    @Transactional
    public String delete(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("다시 확인해주세요"));
        commentRepository.delete(comment);
        return "삭제되었습니다.";
    }

}
