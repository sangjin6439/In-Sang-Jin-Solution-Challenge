package gdsc.insangjinsolutionchallenge.domain.submission;

import gdsc.insangjinsolutionchallenge.domain.example.Example;
import gdsc.insangjinsolutionchallenge.domain.example.ExampleRepository;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import gdsc.insangjinsolutionchallenge.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final UserRepository userRepository;
    private final ExampleRepository exampleRepository;

    @Transactional
    public Submission saveSubmission(Principal principal, Long exampleId, RequestSubmissionDto requestSubmissionDto) {
        User userinfo = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("올바른 유저 정보를 입력해 주세요."));
        Example example = exampleRepository.findById(exampleId)
                .orElseThrow(() -> new IllegalArgumentException("올바른 문제 번호를 입력해 주세요."));

        Submission submission = Submission.builder()
                .user(userinfo)
                .example(example)
                .userAnswer(requestSubmissionDto.getUserAnswer())
                .build();

        submission.setCorrect(submission.checkAnswer(example));

        if (submission.isCorrect()) {
            userinfo.addTotalScoreAndUpdateLevel(example.getScore());
        }
        submissionRepository.save(submission);


        userRepository.save(userinfo);

        int totalSubmissions = example.getSubmissions().size();

        int correctSubmissions = (int) example.getSubmissions().stream()
                .filter(Submission::isCorrect)
                .count();
        System.out.println(correctSubmissions);
        double correctPercentage = ((double) correctSubmissions / totalSubmissions) * 100;
        example.saveCorrectPercentage(correctPercentage);

        return submission;
    }


    @Transactional(readOnly = true)
    public List<ResponseSubmission> findSubmission(Long exmapleId) {
       Example example = exampleRepository.findById(exmapleId).orElseThrow(()-> new IllegalArgumentException("없는 문제입니다."));
       List<Submission> submissions =example.getSubmissions();
       List<ResponseSubmission> responseSubmission = new ArrayList<>();

        for (Submission submission : submissions) {
            ResponseSubmission responseSubmission1 = ResponseSubmission.builder()
                    .userAnswer(submission.getUserAnswer())
                    .correct(submission.isCorrect())
                    .createAt(submission.getCreateAt())
                    .build();

            responseSubmission.add(responseSubmission1);
        }
        return responseSubmission;
    }


    private Submission findById(Long submissionId) {
        return submissionRepository.findById(submissionId)
                .orElseThrow(() -> new IllegalArgumentException("정확한 제출 번호를 입력하세요"));
    }


}
