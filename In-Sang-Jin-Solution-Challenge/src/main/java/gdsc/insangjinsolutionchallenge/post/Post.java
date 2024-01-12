package gdsc.insangjinsolutionchallenge.post;

import gdsc.insangjinsolutionchallenge.common.DateEntity;
import gdsc.insangjinsolutionchallenge.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Post extends DateEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static Post toEntity(RequestPostDto requestPostDto){
        return Post.builder()
                .title(requestPostDto.getTitle())
                .content(requestPostDto.getContent())
                .build();
    }
}
