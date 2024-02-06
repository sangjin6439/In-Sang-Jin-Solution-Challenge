package gdsc.insangjinsolutionchallenge.domain.user;

import com.google.firebase.auth.FirebaseToken;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Setter
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    //받아 오는거 추가해야함
    private String country;

    private int age;

    private String school;

    private String pictureUrl;

    private int totalScore;

    //buider 패턴으로 기본값을 1로 설정
    private int level;

    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
    private Role role;


    public void update(FirebaseToken token) {
        this.email = token.getEmail();
    }

    // 이름, 나이, 학교 바꿀 수 있게 열어둠
    public void updateUser(RequestUserDto requestUserDto) {
        this.age = requestUserDto.getAge();
        this.school = requestUserDto.getSchool();
        this.country = requestUserDto.getCountry();
    }

    //점수 획득 및 레벨 상승
    public void addTotalScoreAndUpdateLevel(Long score) {
        this.totalScore += score;
        this.level = (this.totalScore / 100);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
