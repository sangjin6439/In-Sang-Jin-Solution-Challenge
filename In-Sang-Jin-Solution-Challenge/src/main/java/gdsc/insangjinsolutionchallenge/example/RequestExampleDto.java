package gdsc.insangjinsolutionchallenge.example;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RequestExampleDto {
    private String title;
    private String content;
    private MultipartFile img;
    private String correct;
    private Integer score;
    private String category;
    private String grade;
}
