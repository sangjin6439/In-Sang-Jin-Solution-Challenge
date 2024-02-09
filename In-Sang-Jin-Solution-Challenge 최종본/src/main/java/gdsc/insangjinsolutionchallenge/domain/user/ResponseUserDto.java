package gdsc.insangjinsolutionchallenge.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDto {
    private String email;

    public static ResponseUserDto of(User user) {
        return new ResponseUserDto(user.getEmail());
    }
}
