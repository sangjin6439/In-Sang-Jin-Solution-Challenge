package gdsc.insangjinsolutionchallenge.submission;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseSubmission {

    private String userAnswer;
    private String correct;
    private LocalDateTime createAt;


}
