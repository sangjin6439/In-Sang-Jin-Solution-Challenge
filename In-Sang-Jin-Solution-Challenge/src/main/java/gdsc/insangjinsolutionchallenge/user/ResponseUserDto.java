package gdsc.insangjinsolutionchallenge.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseUserDto {
    private String name;
    private Long age;
    private String email;
    private String school;
    private Integer tier;
    private Integer totalScore;
    private Role role;
    private LocalDateTime creatAt;
    private LocalDateTime updateAt;

    public static ResponseUserDto toDto(User user) {
        return ResponseUserDto.builder()
                .name(user.getName())
                .age(user.getAge())
                .email(user.getEmail())
                .school(user.getSchool())
                .totalScore(user.getTotalScore())
                .tier(user.getTier())
                .role(user.getRole())
                .creatAt(user.getCreateAt())
                .updateAt(user.getUpdateAt())
                .build();
    }


}
