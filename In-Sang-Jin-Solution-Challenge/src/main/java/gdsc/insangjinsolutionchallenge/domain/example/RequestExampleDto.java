package gdsc.insangjinsolutionchallenge.domain.example;

import lombok.Data;

@Data
public class RequestExampleDto {
    private String title;
    private String content;
    private String multipleChoice;
    private String imgPath;
    private String correct;
    private String category;
    private String grade;
    //integer로 하면 프론트에서 보내는데 오류가 남(?) 왜지
    private Long score;
}
