package gdsc.insangjinsolutionchallenge.domain.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseExampleListDto {
    private Long id;
    private String title;
    private String content;
    private String multipleChoice;
    private Long score;
    private String grade;
    private String category;
    private String correct;
    private Double correctPercentage;
    private String imgPath;
}
