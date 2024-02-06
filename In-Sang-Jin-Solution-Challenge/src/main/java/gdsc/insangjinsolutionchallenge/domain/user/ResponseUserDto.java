package gdsc.insangjinsolutionchallenge.domain.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseUserDto {
    private String name;
    private Integer age;
    private String email;
    private String school;
    private String country;
    private String pictureUrl;
    private Integer level;
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
                .country(user.getCountry())
                .pictureUrl(user.getPictureUrl())
                .totalScore(user.getTotalScore())
                .level(user.getLevel())
                .role(user.getRole())
                .build();
    }
}
