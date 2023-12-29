package gdsc.insangjinsolutionchallenge.Example;

import gdsc.insangjinsolutionchallenge.common.DateEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Example extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String imgPath;

    public static Example toEntity(RequestExampleDto requestExampleDto){
        return Example.builder()
                .title(requestExampleDto.getTitle())
                .build();
    }
    public void saveImgPath(String imgPath){
        this.imgPath=imgPath;
    }
}
