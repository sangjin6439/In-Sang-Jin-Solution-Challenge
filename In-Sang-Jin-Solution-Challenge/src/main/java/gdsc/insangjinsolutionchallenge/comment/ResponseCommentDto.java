package gdsc.insangjinsolutionchallenge.comment;

import lombok.Data;

@Data
public class ResponseCommentDto {
    private Long id;
    private Long userId;
    private Long postId;
    private String content;
}
