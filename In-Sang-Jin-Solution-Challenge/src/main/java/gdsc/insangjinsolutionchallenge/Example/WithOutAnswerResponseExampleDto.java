package gdsc.insangjinsolutionchallenge.Example;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
public class WithOutAnswerResponseExampleDto {

    private String title;

    private String img;

    private Integer score;

    private LocalDateTime creatAt;

    private LocalDateTime updateAt;

    public static WithOutAnswerResponseExampleDto toDto(Example example){
        return WithOutAnswerResponseExampleDto.builder()
                .title(example.getTitle())
                .img(example.getImgPath())
                .score(example.getScore())
                .creatAt(example.getCreateAt())
                .updateAt(example.getUpdateAt())
                .build();
    }
}
