package gdsc.insangjinsolutionchallenge.example;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RequestExampleDto {
    private String title;
    private String content;
    private MultipartFile img;
    private String correct;
    //integer로 하면 프론트에서 보내는데 오류가 남(?) 왜지
    private Integer score;
    private String category;
    private String grade;
}
