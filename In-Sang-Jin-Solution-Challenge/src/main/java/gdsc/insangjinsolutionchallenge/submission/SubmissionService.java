package gdsc.insangjinsolutionchallenge.submission;

import gdsc.insangjinsolutionchallenge.example.Example;
import gdsc.insangjinsolutionchallenge.example.ExampleRepository;
import gdsc.insangjinsolutionchallenge.user.User;
import gdsc.insangjinsolutionchallenge.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final UserRepository userRepository;
    private final ExampleRepository exampleRepository;

    @Transactional
    public Submission saveSubmission(RequestSubmissionDto requestSubmissionDto) {
        User user = userRepository.findById(requestSubmissionDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("올바른 유저 정보를 입력해 주세요."));
        Example example = exampleRepository.findById(requestSubmissionDto.getExampleId())
                .orElseThrow(() -> new IllegalArgumentException("올바른 문제 번호를 입력해 주세요."));

        Submission submission = Submission.builder()
                .user(user)
                .example(example)
                .userAnswer(requestSubmissionDto.getUserAnswer())
                .build();

        if (submission.isCorrect()) {
            user.addTotalScoreAndUpdateLevel(example.getScore());
        }
        submission.setCorrect(submission.checkAnswer(example));

        submissionRepository.save(submission);

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
    public ResponseSubmission findSubmission(Long submissionId) {
        Submission submission = findById(submissionId);
        return ResponseSubmission.builder()
                .id(submission.getId())
                .exampleId(submission.getExample().getId())
                .userAnswer(submission.getUserAnswer())
                .correct(submission.isCorrect())
                .createAt(submission.getCreateAt())
                .build();
    }

    @Transactional(readOnly = true)
    public List<Submission> findAll() {
        return submissionRepository.findAll();
    }

    private Submission findById(Long submissionId) {
        return submissionRepository.findById(submissionId)
                .orElseThrow(() -> new IllegalArgumentException("정확한 제출 번호를 입력하세요"));
    }


}
