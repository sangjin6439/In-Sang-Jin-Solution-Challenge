package gdsc.insangjinsolutionchallenge.domain.comment;

import gdsc.insangjinsolutionchallenge.domain.DateEntity;
import gdsc.insangjinsolutionchallenge.domain.post.Post;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Comment extends DateEntity {

    @Id
    @GeneratedValue
    @Column(name="comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Column(nullable = false)
    private String content;

    public static Comment toEntity(RequestCommentDto requestCommentDto){
       return Comment.builder()
                .content(requestCommentDto.getContent())
                .build();
    }
}
