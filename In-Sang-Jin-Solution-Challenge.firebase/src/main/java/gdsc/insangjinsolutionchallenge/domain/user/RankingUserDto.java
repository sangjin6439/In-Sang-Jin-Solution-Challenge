package gdsc.insangjinsolutionchallenge.domain.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RankingUserDto {

    private String name;
    private String email;
    private Integer totalScore;
    private int level;
}
