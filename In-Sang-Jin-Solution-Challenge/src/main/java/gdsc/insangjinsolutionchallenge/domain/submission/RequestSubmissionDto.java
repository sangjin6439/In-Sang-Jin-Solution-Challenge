package gdsc.insangjinsolutionchallenge.domain.submission;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestSubmissionDto {

//    private Long userId;
//    private Long exampleId;

    @NotBlank(message = "글자를 입력해 주세요.")
    private String userAnswer;

}