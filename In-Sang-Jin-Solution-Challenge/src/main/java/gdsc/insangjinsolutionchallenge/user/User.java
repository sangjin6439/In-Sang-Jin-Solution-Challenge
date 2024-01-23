package gdsc.insangjinsolutionchallenge.user;

import gdsc.insangjinsolutionchallenge.common.DateEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Setter
public class User extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    //@Column(nullable = false)
    private String firebaseUid;

//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private String email;

    //받아 오는거 추가해야함
    private String address;

    private Long age;

    private String school;

    private String pictureUrl;

    private int totalScore;

    //buider 패턴으로 기본값을 1로 설정
    private int level;

    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
    private Role role;

    public static User toEntity(RequestUserDto requestuserDto) {
        return User.builder()
                .age(requestuserDto.getAge())
                .school(requestuserDto.getSchool())
                .level(1)
                .totalScore(0)
                .build();
    }

    // 이름, 나이, 학교 바꿀 수 있게 열어둠
    public void update(RequestUserDto requestUserDto) {
        this.age = requestUserDto.getAge();
        this.school = requestUserDto.getSchool();
    }

    //id추가 메서드
    public void addFirebaseUid(String token, String email) {
        User.builder().firebaseUid(token)
                .email(email).build();
    }

    //점수 획득 및 레벨 상승
    public void addTotalScoreAndUpdateLevel(int score) {
        this.totalScore += score;
        this.level = (this.totalScore / 100);
    }

}
