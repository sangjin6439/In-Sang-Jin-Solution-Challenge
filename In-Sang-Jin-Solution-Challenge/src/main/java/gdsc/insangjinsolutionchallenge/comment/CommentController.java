package gdsc.insangjinsolutionchallenge.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/save/{postId}")
    public String save(@PathVariable("postId") Long postId, @RequestBody RequestCommentDto requestCommentDto){
        return commentService.save(postId, requestCommentDto);
    }

    @GetMapping("/find/{postId}")
    public List<ResponseCommentDto> findAll(@PathVariable("postId") Long postId){
        return commentService.findAll(postId);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return commentService.delete(id);
    }
}
