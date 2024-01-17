package gdsc.insangjinsolutionchallenge.submission;

import lombok.Data;

@Data
public class RequestSubmissionDto {

    private Long userId;
    private Long exampleId;
    private String userAnswer;

}