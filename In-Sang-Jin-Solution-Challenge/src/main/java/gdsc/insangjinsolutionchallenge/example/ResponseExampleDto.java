package gdsc.insangjinsolutionchallenge.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseExampleDto {

    private String Answer;

    public static ResponseExampleDto answerResponseDto(Example example){
        return ResponseExampleDto.builder()
                .Answer(example.getAnswer())
                .build();
    }

}
