package gdsc.insangjinsolutionchallenge.submission;

import gdsc.insangjinsolutionchallenge.Example.Example;
import gdsc.insangjinsolutionchallenge.common.DateEntity;
import gdsc.insangjinsolutionchallenge.user.User;
import jakarta.persistence.*;
import jdk.jfr.Name;
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
    private Long id;

    @Column(nullable = false)
    private String userAnswer;

    private String correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "example_id")
    private Example example;


    // 정답 확인 메서드
    public String checkAnswer(Example example) {
        if (example.getAnswer().equals(userAnswer)) {
            return correct = "정답";
        } else {
            return correct = "오답";
        }
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
