package gdsc.insangjinsolutionchallenge.domain.comment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/save/{postId}")
    public String save(Principal principal, @PathVariable("postId") Long postId, @RequestBody @Valid RequestCommentDto requestCommentDto){
        return commentService.save(principal, postId, requestCommentDto);
    }

    @GetMapping("/find/{postId}")
    public List<ResponseCommentDto> findAll(@PathVariable("postId") Long postId){
        return commentService.findAll(postId);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(Principal principal,@PathVariable("id") Long id){
        return commentService.delete(principal,id);
    }
}
