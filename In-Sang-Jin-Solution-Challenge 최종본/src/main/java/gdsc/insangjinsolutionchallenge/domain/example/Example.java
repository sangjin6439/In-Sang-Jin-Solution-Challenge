package gdsc.insangjinsolutionchallenge.domain.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gdsc.insangjinsolutionchallenge.domain.DateEntity;
import gdsc.insangjinsolutionchallenge.domain.submission.Submission;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "example")
@Getter
@Builder
public class Example extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "example_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String multipleChoice;

    @Column(nullable = false)
    private String imgPath;

    @Column(nullable = false)
    private String correct;

    //정답률
    @Column(name = "correct_percentage")
    private double correctPercentage;

    @Column(nullable = false)
    private Long score;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String grade;

    //builder패턴일때 new array로 안만듬
    @JsonIgnore
    @OneToMany(mappedBy = "example", cascade = CascadeType.ALL)
    private List<Submission> submissions;


    public static Example toEntity(RequestExampleDto requestExampleDto) {
        return Example.builder()
                .title(requestExampleDto.getTitle())
                .content(requestExampleDto.getContent())
                .multipleChoice(requestExampleDto.getMultipleChoice())
                .imgPath(requestExampleDto.getImgPath())
                .correct(requestExampleDto.getCorrect())
                .score(requestExampleDto.getScore())
                .category(requestExampleDto.getCategory())
                .grade(requestExampleDto.getGrade())
                .build();
    }


    public void saveCorrectPercentage(double correctPercentage){
        this.correctPercentage=correctPercentage;
    }

    public void update(RequestExampleDto requestExampleDto) {
        this.title = requestExampleDto.getTitle();
        this.content = requestExampleDto.getContent();
        this.multipleChoice = requestExampleDto.getMultipleChoice();
        this.correct = requestExampleDto.getCorrect();
        this.score = requestExampleDto.getScore();
        this.grade = requestExampleDto.getGrade();
    }
}
