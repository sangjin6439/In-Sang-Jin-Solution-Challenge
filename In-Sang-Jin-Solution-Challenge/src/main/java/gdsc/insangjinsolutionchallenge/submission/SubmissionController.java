package gdsc.insangjinsolutionchallenge.submission;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("/save")
    public Submission save(Principal principal, @RequestBody RequestSubmissionDto requestSubmissionDto){
        principal.getName();
        return submissionService.saveSubmission(requestSubmissionDto);
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
