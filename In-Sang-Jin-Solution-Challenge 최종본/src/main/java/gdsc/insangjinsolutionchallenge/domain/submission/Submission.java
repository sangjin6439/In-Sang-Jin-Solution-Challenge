package gdsc.insangjinsolutionchallenge.domain.submission;

import gdsc.insangjinsolutionchallenge.domain.example.Example;
import gdsc.insangjinsolutionchallenge.domain.DateEntity;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "submission")
@Builder
@Getter
public class Submission extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private Long id;

    @Column(nullable = false)
    private String userAnswer;

    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "example_id")
    private Example example;


    // 정답 확인 메서드
    public boolean checkAnswer(Example example) {
        if (example.getCorrect().equals(userAnswer)) {
            return correct = true;
        } else {
            return correct = false;
        }
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
