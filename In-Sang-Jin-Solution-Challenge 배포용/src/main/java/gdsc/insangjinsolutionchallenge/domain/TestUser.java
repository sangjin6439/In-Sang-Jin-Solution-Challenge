package gdsc.insangjinsolutionchallenge.domain;

import gdsc.insangjinsolutionchallenge.domain.user.Role;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import gdsc.insangjinsolutionchallenge.domain.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestUser {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            // 더미 데이터 생성
            repository.save(User.builder()
                    .firebaseUid("testUid")
                    .name("testName")
                    .email("test@example.com")
                    .address("testAddress")
                    .age(24)
                    .school("testSchool")
                    .pictureUrl("testUrl")
                    .totalScore(0)
                    .level(1)
                    .role(Role.STUDENT)
                    .build());
        };
    }
}
