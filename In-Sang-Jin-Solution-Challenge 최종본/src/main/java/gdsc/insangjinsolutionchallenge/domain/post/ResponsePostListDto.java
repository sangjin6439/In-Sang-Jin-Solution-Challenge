package gdsc.insangjinsolutionchallenge.domain.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ResponsePostListDto {
    // 웹으로 몇번째 post인지 알게해야함 그래야 이 포스트를 수정하게함
    private Long id;
    private String userName;
    private Integer userLevel;
    private String title;
    private String content;
    private int likeCount;
    private LocalDateTime createAt;
}