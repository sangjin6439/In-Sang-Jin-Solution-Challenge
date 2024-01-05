package gdsc.insangjinsolutionchallenge.Example;

import gdsc.insangjinsolutionchallenge.common.DateEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "example")
@Getter
@Builder
public class Example extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String imgPath;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String grade;

    public static Example toEntity(RequestExampleDto requestExampleDto) {
        return Example.builder()
                .title(requestExampleDto.getTitle())
                .answer(requestExampleDto.getAnswer())
                .score(requestExampleDto.getScore())
                .category(requestExampleDto.getCategory())
                .grade(requestExampleDto.getGrade())
                .build();
    }

    public void saveImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void update(RequestExampleDto requestExampleDto) {
        this.title = requestExampleDto.getTitle();
        this.answer = requestExampleDto.getAnswer();
        this.score = requestExampleDto.getScore();
        this.grade = requestExampleDto.getGrade();
    }

}
