package gdsc.insangjinsolutionchallenge.post;

import gdsc.insangjinsolutionchallenge.comment.Comment;
import gdsc.insangjinsolutionchallenge.common.DateEntity;
import gdsc.insangjinsolutionchallenge.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Post extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comment;

    public static Post toEntity(RequestPostDto requestPostDto){
        return Post.builder()
                .title(requestPostDto.getTitle())
                .content(requestPostDto.getContent())
                .build();
    }
}
