package gdsc.insangjinsolutionchallenge.domain.example;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseExampleDto {
    private Long id;
    private String title;
    private String content;
    private String multipleChoice;
    private String imgPath;
    private String correct;
    private Double correctPercentage;
    private Long score;
    private String category;
    private String grade;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public static ResponseExampleDto toDto(Example example){
        return ResponseExampleDto.builder()
                .id(example.getId())
                .title(example.getTitle())
                .imgPath(example.getImgPath())
                .correct(example.getCorrect())
                .correctPercentage(example.getCorrectPercentage())
                .score(example.getScore())
                .category(example.getCategory())
                .grade(example.getGrade())
                .createAt(example.getCreateAt())
                .updateAt(example.getUpdateAt())
                .build();
    }
}