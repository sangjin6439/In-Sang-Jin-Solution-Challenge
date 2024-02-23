package gdsc.insangjinsolutionchallenge.domain.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ResponseCommentDto {
    private Long id;
    private String userName;
    private Integer userLevel;
    private String content;
    private LocalDateTime createAt;

    public static ResponseCommentDto toDto(Comment comment) {
        return ResponseCommentDto.builder()
                .id(comment.getId())
                .userName(comment.getUser().getName())
                .userLevel(comment.getUser().getLevel())
                .content(comment.getContent())
                .createAt(comment.getCreateAt())
                .build();
    }

}
