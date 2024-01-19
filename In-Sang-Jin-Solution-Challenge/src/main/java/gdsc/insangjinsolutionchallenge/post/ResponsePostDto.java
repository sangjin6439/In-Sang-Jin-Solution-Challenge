package gdsc.insangjinsolutionchallenge.post;

import gdsc.insangjinsolutionchallenge.comment.ResponseCommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ResponsePostDto {
    // 웹으로 몇번째 post인지 알게해야함 그래야 이 포스트를 수정하게함
    private Long id;
    private String userName;
    private Integer userLevel;
    private String title;
    private String content;
    private List<ResponseCommentDto> comments;
    private LocalDateTime creatAt;
    private LocalDateTime updateAt;

    public static ResponsePostDto toDto(Post post){
        return ResponsePostDto.builder()
                .id(post.getId())
                .userName(post.getUser().getName())
                .userLevel(post.getUser().getLevel())
                .title(post.getTitle())
                .content(post.getContent())
                .creatAt(post.getCreateAt())
                .updateAt(post.getUpdateAt())
                .build();
    }
}
