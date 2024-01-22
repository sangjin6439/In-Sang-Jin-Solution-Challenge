package gdsc.insangjinsolutionchallenge.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gdsc.insangjinsolutionchallenge.common.DateEntity;
import gdsc.insangjinsolutionchallenge.submission.Submission;
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

    @Column(nullable = false)
    private String imgPath;

    @Column(nullable = false)
    private String correct;

    //builder패턴일때 new array로 안만듬
    @JsonIgnore
    @OneToMany(mappedBy = "example", cascade = CascadeType.ALL)
    private List<Submission> submissions;

    //정답률
    @Column(name = "correct_percentage")
    private double correctPercentage;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String grade;

    public static Example toEntity(RequestExampleDto requestExampleDto) {
        return Example.builder()

                .title(requestExampleDto.getTitle())
                .content(requestExampleDto.getContent())
                .correct(requestExampleDto.getCorrect())
                .score(requestExampleDto.getScore())
                .category(requestExampleDto.getCategory())
                .grade(requestExampleDto.getGrade())
                .build();
    }

    public void saveImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void saveCorrectPercentage(double correctPercentage){
        this.correctPercentage=correctPercentage;
    }

    public void update(RequestExampleDto requestExampleDto) {
        this.title = requestExampleDto.getTitle();
        this.content = requestExampleDto.getContent();
        this.correct = requestExampleDto.getCorrect();
        this.score = requestExampleDto.getScore();
        this.grade = requestExampleDto.getGrade();
    }


}
