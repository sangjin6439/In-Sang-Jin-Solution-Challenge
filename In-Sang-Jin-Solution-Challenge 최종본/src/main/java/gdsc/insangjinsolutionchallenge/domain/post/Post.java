package gdsc.insangjinsolutionchallenge.domain.post;

import gdsc.insangjinsolutionchallenge.domain.comment.Comment;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import gdsc.insangjinsolutionchallenge.domain.DateEntity;
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

    @Builder.Default
    private int likeCount = 0;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comment;


    public void update( RequestPostDto requestPostDto){
        this.title= requestPostDto.getTitle();
        this.content= requestPostDto.getContent();
    }

    public static Post update1(Post post, RequestPostDto requestPostDto){
        return post.builder()
                .title(requestPostDto.getTitle())
                .content(requestPostDto.getContent())
                .build();
    }

    public void addLikeCount(int likeCount){
        this.likeCount=likeCount;
    }

}
