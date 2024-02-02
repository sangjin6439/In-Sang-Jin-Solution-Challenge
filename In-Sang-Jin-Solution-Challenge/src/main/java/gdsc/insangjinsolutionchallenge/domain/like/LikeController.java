package gdsc.insangjinsolutionchallenge.domain.like;


import gdsc.insangjinsolutionchallenge.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{postId}")
    public ResponseEntity addLike(@AuthenticationPrincipal User user,@PathVariable("postId") Long postId){
        likeService.addLike(user,postId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
