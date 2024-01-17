package gdsc.insangjinsolutionchallenge.example;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseExampleDto {
    private Long id;
    private String title;
    private String img;
    private String correct;
    private Double correctPercentage;
    private Integer score;
    private String category;
    private String grade;
    private LocalDateTime creatAt;
    private LocalDateTime updateAt;

    public static ResponseExampleDto toDto(Example example){
        return ResponseExampleDto.builder()
                .id(example.getId())
                .title(example.getTitle())
                .img(example.getImgPath())
                .correct(example.getCorrect())
                .correctPercentage(example.getCorrectPercentage())
                .score(example.getScore())
                .category(example.getCategory())
                .grade(example.getGrade())
                .creatAt(example.getCreateAt())
                .updateAt(example.getUpdateAt())
                .build();
    }
}