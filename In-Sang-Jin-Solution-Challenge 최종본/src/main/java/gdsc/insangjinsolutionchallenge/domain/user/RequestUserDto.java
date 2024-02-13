package gdsc.insangjinsolutionchallenge.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestUserDto {
    private String name;
    private Integer age;
    private String school;
    private String country;
}
