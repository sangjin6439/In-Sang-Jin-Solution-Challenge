package gdsc.insangjinsolutionchallenge.Example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerResponseDto {

    private String Answer;

    public static AnswerResponseDto answerResponseDto(Example example){
        return AnswerResponseDto.builder()
                .Answer(example.getAnswer())
                .build();
    }

}
