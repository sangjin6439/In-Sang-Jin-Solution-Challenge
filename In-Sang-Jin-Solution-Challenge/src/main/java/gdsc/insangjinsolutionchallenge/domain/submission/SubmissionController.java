package gdsc.insangjinsolutionchallenge.domain.submission;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("/save/{exampleId}")
    public Submission save(Principal principal, @PathVariable("exampleId") Long exampleId, @RequestBody @Valid RequestSubmissionDto requestSubmissionDto){
        return submissionService.saveSubmission(principal, exampleId, requestSubmissionDto);
    }

    //문제 번호로 유저 제출 찾기
    @GetMapping("/find/{exampleId}")
    public List<ResponseSubmission> find(@PathVariable("exampleId") Long exampleId){
        return submissionService.findSubmission(exampleId);
    }


}