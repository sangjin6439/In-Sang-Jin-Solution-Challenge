package gdsc.insangjinsolutionchallenge.post;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestPostDto {
    private Long userId;
    private String title;
    private String content;
}
