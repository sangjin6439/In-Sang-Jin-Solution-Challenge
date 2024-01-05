package gdsc.insangjinsolutionchallenge.Example;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RequestExampleDto {
    private String title;
    private MultipartFile img;
    private String answer;
    private Integer score;
    private String category;
    private String grade;
}
