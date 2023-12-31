package gdsc.insangjinsolutionchallenge.submission;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseSubmission {

    private String userAnswer;
    private Boolean correct;
    private LocalDateTime createAt;


}
