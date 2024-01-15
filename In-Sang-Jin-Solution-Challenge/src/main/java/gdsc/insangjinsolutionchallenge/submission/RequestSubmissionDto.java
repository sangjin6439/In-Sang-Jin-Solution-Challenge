package gdsc.insangjinsolutionchallenge.submission;

import lombok.Data;

@Data
public class RequestSubmissionDto {

    private Long userId;
    //웹이 알아서 example
    private Long exampleId;
    private String userAnswer;

}