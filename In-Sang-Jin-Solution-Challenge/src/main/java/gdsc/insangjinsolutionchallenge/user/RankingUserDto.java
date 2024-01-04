package gdsc.insangjinsolutionchallenge.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RankingUserDto {

    private String name;
    private String email;
    @Builder.Default
    private Integer totalScore = 0;
    private String tier;


}
