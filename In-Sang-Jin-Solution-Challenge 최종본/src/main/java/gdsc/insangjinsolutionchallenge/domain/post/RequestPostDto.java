package gdsc.insangjinsolutionchallenge.domain.post;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestPostDto {

        @NotBlank(message = "글자를 입력해 주세요.")
        private String title;

        @NotBlank(message = "글자를 입력해 주세요.")
        private String content;
}
