package gdsc.insangjinsolutionchallenge.comment;

import lombok.Data;

@Data
public class RequestCommentDto {
    private Long userId;
    private String content;
}
