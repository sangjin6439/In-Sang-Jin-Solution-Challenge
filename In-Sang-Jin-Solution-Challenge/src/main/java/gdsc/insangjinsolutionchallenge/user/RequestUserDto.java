package gdsc.insangjinsolutionchallenge.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestUserDto {
    private String name;
    private Long age;
    private String email;
    private String school;
}
