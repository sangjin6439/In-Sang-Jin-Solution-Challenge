package gdsc.insangjinsolutionchallenge.domain.submission;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseSubmission {

//    private Long id;
//    private Long exampleId;
    private String userAnswer;
    private Boolean correct;
    private LocalDateTime createAt;

}
