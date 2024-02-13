package gdsc.insangjinsolutionchallenge.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {

    @Email
    private String email;
    @NotBlank
    private String password;

    private Authority authority;

    private String name;

    private Integer age;

    private String school;

    private String country;

    public User toUser(PasswordEncoder passwordEncoder){
        return User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .authority(authority)
                .age(age)
                .name(name)
                .school(school)
                .country(country)
                .build();
    }
    public UsernamePasswordAuthenticationToken toAuthentication(){
        return new UsernamePasswordAuthenticationToken(email,password);
    }
}
