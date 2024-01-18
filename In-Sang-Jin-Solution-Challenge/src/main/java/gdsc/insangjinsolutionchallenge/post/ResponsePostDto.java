package gdsc.insangjinsolutionchallenge.post;

import gdsc.insangjinsolutionchallenge.comment.Comment;

import java.util.List;

public class ResponsePostDto {
    // 웹으로 몇번째 post인지 알게해야함 그래야 이 포스트를 수정하게함
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private List<Comment> comments;
}
