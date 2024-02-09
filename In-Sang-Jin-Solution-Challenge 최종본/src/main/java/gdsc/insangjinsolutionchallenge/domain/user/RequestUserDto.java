package gdsc.insangjinsolutionchallenge.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserDto {
    private String email;
    private String password;
    private Authority authority;
    private LocalDateTime createAt;

    public User toUser(PasswordEncoder passwordEncoder){
        return User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .authority(authority)

                .build();
    }
    public UsernamePasswordAuthenticationToken toAuthentication(){
        return new UsernamePasswordAuthenticationToken(email,password);
    }
}
