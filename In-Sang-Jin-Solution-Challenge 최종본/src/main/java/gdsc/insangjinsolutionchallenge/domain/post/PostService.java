package gdsc.insangjinsolutionchallenge.domain.post;

import gdsc.insangjinsolutionchallenge.domain.comment.CommentService;
import gdsc.insangjinsolutionchallenge.domain.comment.ResponseCommentDto;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import gdsc.insangjinsolutionchallenge.domain.user.UserRepository;
import gdsc.insangjinsolutionchallenge.global.exception.ApplicationErrorException;
import gdsc.insangjinsolutionchallenge.global.exception.ApplicationErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final CommentService commentService;
    private final UserRepository userRepository;

    @Transactional
    public String save(Long userId, RequestPostDto requestPostDto){
        User userInfo = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("없는 유저입니다."));

        Post post = Post.builder()
                .title(requestPostDto.getTitle())
                .content(requestPostDto.getContent())
                .user(userInfo)
                .build();
        postRepository.save(post);
        return "저장 완료!";
    }
    // all이면 전체 , 아니면 likeCount로 검색
    @Transactional(readOnly = true)
    public List<ResponsePostListDto> findAll(String sort){
        List<Post> posts;
        if(sort.equals("all")){
            posts = postRepository.findAll();
        }else {
            posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "likeCount"));
        }

        List<ResponsePostListDto> responsePostDtos = posts.stream()
                .map(post -> ResponsePostListDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .likeCount(post.getLikeCount())
                        .userName(post.getUser().getName())
                        .userLevel(post.getUser().getLevel())
                        .createAt(post.getCreateAt())
                        .build())
                .toList();

        return responsePostDtos;
    }


    // 검색어로 검색
    @Transactional(readOnly = true)
    public List<ResponsePostListDto> findSearchTerm(String searchTerm){
        List<Post> posts = postRepository.findByTitleContaining(searchTerm);
        List<ResponsePostListDto> responsePostDtos = posts.stream()
                .map(post -> ResponsePostListDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .likeCount(post.getLikeCount())
                        .userName(post.getUser().getName())
                        .userLevel(post.getUser().getLevel())
                        .createAt(post.getCreateAt())
                        .build())
                .toList();
        return responsePostDtos;
    }

    @Transactional(readOnly = true)
    public ResponsePostDto find(Long id){
        Post post = findPostDao(id);
        List<ResponseCommentDto> commentDtos = commentService.findAll(id);

        ResponsePostDto responsePostDto = ResponsePostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .userName(post.getUser().getName())
                .userLevel(post.getUser().getLevel())
                .comments(commentDtos)
                .createAt(post.getCreateAt())
                .updateAt(post.getUpdateAt())
                .likeCount(post.getLikeCount())
                .build();
        return responsePostDto;
    }


    @Transactional
    public String update(Long userId, Long id, RequestPostDto requestPostDto){
        String userEmail = findPostDao(id).getUser().getEmail();
        String myEmail = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("없는 사용자입니다")).getEmail();
        if(!userEmail.equals(myEmail)){
            throw new ApplicationErrorException(ApplicationErrorType.UNAUTHORIZED,"권한이 없는 사용자입니다.");
        }
        Post post = findPostDao(id);
        post.update(requestPostDto);
        return "수정 완료!";
    }

    @Transactional
    public String delete(Long userId, Long id){
        Long authorId = Long.valueOf(String.valueOf(findPostDao(id).getUser().getId()));
        if(!authorId.equals(userId)){
            throw new ApplicationErrorException(ApplicationErrorType.UNAUTHORIZED,"권한이 없는 사용자입니다.");
        }
        postRepository.delete(findPostDao(id));
        return "삭제 완료";
    }


    public Post findPostDao(Long id){
        return postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("다시 확인하세요."));
    }

}
