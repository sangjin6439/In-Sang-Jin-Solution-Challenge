package gdsc.insangjinsolutionchallenge.submission;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping
    public Submission save(@RequestBody RequestSubmissionDto requestSubmissionDto){
        return submissionService.saveSubmission(requestSubmissionDto);
    }

    @GetMapping("/{id}")
    public ResponseSubmission find(@PathVariable("id") Long id){
        return submissionService.findSubmission(id);
    }


    @GetMapping
    public List<Submission> findAll(){
        return submissionService.findAll();
    }
}
