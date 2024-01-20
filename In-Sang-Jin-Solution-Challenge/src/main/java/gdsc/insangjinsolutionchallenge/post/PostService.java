package gdsc.insangjinsolutionchallenge.post;

import gdsc.insangjinsolutionchallenge.comment.CommentService;
import gdsc.insangjinsolutionchallenge.comment.ResponseCommentDto;
import gdsc.insangjinsolutionchallenge.user.User;
import gdsc.insangjinsolutionchallenge.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final CommentService commentService;
    private final UserRepository userRepository;

    @Transactional
    public String save(RequestPostDto requestPostDto){
        User user = userRepository.findById(requestPostDto.getUserId())
                .orElseThrow(()-> new IllegalArgumentException("없는 유저입니다."));

        Post post = Post.builder()
                .title(requestPostDto.getTitle())
                .content(requestPostDto.getContent())
                .user(user)
                .build();
        postRepository.save(post);
        return "저장 완료!";
    }

    @Transactional(readOnly = true)
    public List<ResponsePostDtoWithOutComment> findAll(){
        List<Post> posts = postRepository.findAll();
        List<ResponsePostDtoWithOutComment> responsePostDtos = new ArrayList<>();

        for (Post post : posts) {
            ResponsePostDtoWithOutComment responsePostDto = ResponsePostDtoWithOutComment.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .userName(post.getUser().getName())
                    .userLevel(post.getUser().getLevel())
                    .creatAt(post.getCreateAt())
                    .build();
            responsePostDtos.add(responsePostDto);
        }
        return responsePostDtos;
    }
    // 검색어로 검색
    @Transactional(readOnly = true)
    public List<ResponsePostDtoWithOutComment> findSearchTerm(String searchTerm){
        List<Post> posts = postRepository.findByTitleContaining(searchTerm);
        List<ResponsePostDtoWithOutComment> responsePostDtos = new ArrayList<>();

        for (Post post : posts) {
            ResponsePostDtoWithOutComment responsePostDto = ResponsePostDtoWithOutComment.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .userName(post.getUser().getName())
                    .userLevel(post.getUser().getLevel())
                    .creatAt(post.getCreateAt())
                    .build();
            responsePostDtos.add(responsePostDto);
        }
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
                .creatAt(post.getCreateAt())
                .updateAt(post.getUpdateAt())
                .build();
        return responsePostDto;
    }

    @Transactional
    public String delete(Long id){
        postRepository.delete(findPostDao(id));
        return "삭제 완료";
    }


    private Post findPostDao(Long id){
        return postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("다시 확인하세요."));
    }

}
