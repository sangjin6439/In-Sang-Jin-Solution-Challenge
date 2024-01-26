package gdsc.insangjinsolutionchallenge.domain.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseExampleListDto {
    private String title;
    private String content;
    private Long score;
    private String grade;
    private String category;

}
