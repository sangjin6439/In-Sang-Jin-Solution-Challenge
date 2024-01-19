package gdsc.insangjinsolutionchallenge.comment;

import gdsc.insangjinsolutionchallenge.common.DateEntity;
import gdsc.insangjinsolutionchallenge.post.Post;
import gdsc.insangjinsolutionchallenge.user.User;
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
