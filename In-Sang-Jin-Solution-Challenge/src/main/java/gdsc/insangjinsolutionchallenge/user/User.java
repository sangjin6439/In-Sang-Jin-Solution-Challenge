package gdsc.insangjinsolutionchallenge.user;

import gdsc.insangjinsolutionchallenge.common.DateEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
@Builder
public class User extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long age;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String school;

    @Column(name = "status")
    private String status;

    @Enumerated(EnumType.STRING)
    private UserRole role;


    public static User toEntity(RequestUserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .age(userDto.getAge())
                .email(userDto.getEmail())
                .school(userDto.getSchool())
                .status(userDto.getStatus())
                .role(UserRole.STUDENT)
                .build();
    }
    public void update(RequestUserDto requestUserDto) {
        this.name = requestUserDto.getName();
        this.age = requestUserDto.getAge();
        this.school= requestUserDto.getSchool();
        this.status = requestUserDto.getStatus();
    }
}
