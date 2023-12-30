package gdsc.insangjinsolutionchallenge.submission;

import gdsc.insangjinsolutionchallenge.Example.Example;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "submission")
@Builder
@Getter
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userAnswer;

    private boolean correct;

    @OneToMany(fetch = FetchType.LAZY)
    private Example example;

}
