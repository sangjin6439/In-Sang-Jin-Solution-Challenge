package gdsc.insangjinsolutionchallenge.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("/save")
    public String save(@RequestBody RequestPostDto requestPostDto) {
        return postService.save(requestPostDto);
    }

    @GetMapping("/find/all")
    public List<ResponsePostDtoWithOutComment> findAll() {
        return postService.findAll();
    }

    // 검색어로 검색하는 기능
    @GetMapping("/find")
    public ResponseEntity<List<ResponsePostDtoWithOutComment>> searchPosts(@RequestParam("searchTerm") String searchTerm) {
        List<ResponsePostDtoWithOutComment> searchResults = postService.findSearchTerm(searchTerm);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponsePostDto find(@PathVariable("id") Long id) {
        return postService.find(id);
    }


    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return postService.delete(id);
    }

}
