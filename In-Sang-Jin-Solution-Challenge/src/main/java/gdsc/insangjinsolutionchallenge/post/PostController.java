package gdsc.insangjinsolutionchallenge.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/save")
    public String save(@RequestBody RequestPostDto requestPostDto){
        return postService.save(requestPostDto);
    }

    @GetMapping("/find/{id}")
    public ResponsePostDto find(@PathVariable Long id){
        return postService.find(id);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return postService.delete(id);
    }

}
