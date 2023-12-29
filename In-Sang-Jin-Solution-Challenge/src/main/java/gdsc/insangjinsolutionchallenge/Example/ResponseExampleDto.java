package gdsc.insangjinsolutionchallenge.Example;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseExampleDto {

    private String title;

    private String img;

    private LocalDateTime creatAt;

    private LocalDateTime updateAt;

    public static ResponseExampleDto toDto(Example example){
        return ResponseExampleDto.builder()
                .title(example.getTitle())
                .img(example.getImgPath())
                .creatAt(example.getCreateAt())
                .updateAt(example.getUpdateAt())
                .build();
    }
}
