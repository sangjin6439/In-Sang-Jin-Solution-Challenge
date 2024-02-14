package gdsc.insangjinsolutionchallenge.domain.like;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Tag(name = "좋아요 API", description = "좋아요관련 API.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{postId}")
    public ResponseEntity addLike(Principal principal, @PathVariable("postId") Long postId){
        likeService.addLike(Long.valueOf(principal.getName()),postId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
