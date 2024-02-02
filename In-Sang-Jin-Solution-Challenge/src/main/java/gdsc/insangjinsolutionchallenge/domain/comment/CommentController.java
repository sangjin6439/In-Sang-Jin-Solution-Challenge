package gdsc.insangjinsolutionchallenge.domain.comment;

import gdsc.insangjinsolutionchallenge.domain.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/save/{postId}")
    public String save(@AuthenticationPrincipal User user, @PathVariable("postId") Long postId, @RequestBody @Valid RequestCommentDto requestCommentDto){
        return commentService.save(user, postId, requestCommentDto);
    }

    @GetMapping("/find/{postId}")
    public List<ResponseCommentDto> findAll(@PathVariable("postId") Long postId){
        return commentService.findAll(postId);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@AuthenticationPrincipal User user,@PathVariable("id") Long id){
        return commentService.delete(user,id);
    }
}
