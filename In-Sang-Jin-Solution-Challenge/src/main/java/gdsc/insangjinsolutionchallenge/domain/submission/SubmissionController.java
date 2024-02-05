package gdsc.insangjinsolutionchallenge.domain.submission;

import gdsc.insangjinsolutionchallenge.domain.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("/save/{exampleId}")
    public Submission save(@AuthenticationPrincipal User user,@PathVariable Long exampleId, @RequestBody @Valid RequestSubmissionDto requestSubmissionDto){
        return submissionService.saveSubmission(user, exampleId, requestSubmissionDto);
    }

    @GetMapping("/find/{id}")
    public ResponseSubmission find(@PathVariable("id") Long id){
        return submissionService.findSubmission(id);
    }


    @GetMapping("/find/all")
    public List<Submission> findAll(){
        return submissionService.findAll();
    }
}