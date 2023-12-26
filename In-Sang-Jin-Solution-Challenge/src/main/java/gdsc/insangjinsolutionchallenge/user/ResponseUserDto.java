package gdsc.insangjinsolutionchallenge.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseUserDto {
    private String name;
    private Long age;
    private String email;
    private String status;
    private UserRole role;

    public static ResponseUserDto toDto(User user) {
        return ResponseUserDto.builder()
                .name(user.getName())
                .age(user.getAge())
                .email(user.getEmail())
                .status(user.getStatus())
                .role(user.getRole())
                .build();
    }

    public void update(RequestUserDto requestUserDto) {
        this.name = requestUserDto.getName();
        this.age = requestUserDto.getAge();
        this.email = requestUserDto.getName();
        this.status = requestUserDto.getStatus();
    }
}
