package gdsc.insangjinsolutionchallenge.domain.post;

import gdsc.insangjinsolutionchallenge.domain.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @PostMapping("/save")
    public String save(Principal principal, @RequestBody @Valid RequestPostDto requestPostDto) {
        return postService.save(principal,requestPostDto);
    }


    @PostMapping
    public Post save(@RequestBody @Valid RequestPostDto requestPostDto) {
        return postRepository.save(Post.builder()
                .user(userRepository.findById(1L))
                .title(requestPostDto.getTitle())
                .content(requestPostDto.getContent())
                .build());
    }

    @GetMapping("/find/list/{sort}")
    public List<ResponsePostListDto> findAll(@PathVariable("sort") String sort) {
        return postService.findAll(sort);
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

    @PatchMapping("/update/{id}")
    public String update(Principal principal, @PathVariable("id")Long id,@RequestBody RequestPostDto requestPostDto){
        return postService.update(principal, id,requestPostDto);
    }

    @DeleteMapping("delete/{id}")
    public String delete(Principal principal, @PathVariable("id") Long id) {
        return postService.delete(principal,id);
    }


}
