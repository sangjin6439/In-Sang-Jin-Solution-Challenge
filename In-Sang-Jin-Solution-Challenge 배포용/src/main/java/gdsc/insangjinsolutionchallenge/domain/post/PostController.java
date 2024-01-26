package gdsc.insangjinsolutionchallenge.domain.post;

import gdsc.insangjinsolutionchallenge.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("/save")
    public String save(@AuthenticationPrincipal User user, @RequestBody RequestPostDto requestPostDto) {
        return postService.save(user,requestPostDto);
    }

    @GetMapping("/find/all")
    public List<ResponsePostListDto> findAll() {
        return postService.findAll();
    }

    // 검색어로 검색하는 기능
    @GetMapping("/find")
    public ResponseEntity<List<ResponsePostListDto>> searchPosts(@RequestParam("searchTerm") String searchTerm) {
        List<ResponsePostListDto> searchResults = postService.findSearchTerm(searchTerm);
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
