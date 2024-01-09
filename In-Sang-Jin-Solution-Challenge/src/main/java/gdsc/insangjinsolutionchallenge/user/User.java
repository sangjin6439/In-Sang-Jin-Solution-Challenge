package gdsc.insangjinsolutionchallenge.user;

import gdsc.insangjinsolutionchallenge.common.DateEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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

    private int totalScore;

    @Enumerated(EnumType.STRING)
//    @ColumnDefault("BRONZE")
    private UserTier tier;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public static User toEntity(RequestUserDto requestuserDto) {
        return User.builder()
                .name(requestuserDto.getName())
                .age(requestuserDto.getAge())
                .email(requestuserDto.getEmail())
                .school(requestuserDto.getSchool())
                .tier(UserTier.BRONZE)
                .role(UserRole.STUDENT)
                .build();
    }

    // 이름, 나이, 학교 바꿀 수 있게 열어둠
    public void update(RequestUserDto requestUserDto) {
        this.name = requestUserDto.getName();
        this.age = requestUserDto.getAge();
        this.school = requestUserDto.getSchool();
    }

    // 점수 추가 메서드
    public void addTotalScore(int score) {
        this.totalScore += score;
    }

    // tier 업데이트 메서드
    public void updateTier(int totalScore){
        if (totalScore< 100){
            this.tier=UserTier.BRONZE;
        }else if(totalScore< 200){
            this.tier=UserTier.SILVER;
        }else if(totalScore< 300){
            this.tier=UserTier.GOLD;
        }else if(totalScore< 400){
            this.tier=UserTier.PLATINUM;
        }else if(totalScore< 500){
            this.tier=UserTier.DIAMOND;
        }else {
            this.tier=UserTier.MASTER;
        }

    }
}
