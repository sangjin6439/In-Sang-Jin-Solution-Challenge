package gdsc.insangjinsolutionchallenge.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDto {
    private String uid;
    private String email;
    private String name;

    // getter, setter, etc.
}