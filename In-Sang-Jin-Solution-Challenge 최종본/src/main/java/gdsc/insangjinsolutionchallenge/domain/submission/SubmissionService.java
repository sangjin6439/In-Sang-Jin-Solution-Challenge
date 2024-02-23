package gdsc.insangjinsolutionchallenge.domain.submission;

import gdsc.insangjinsolutionchallenge.domain.example.Example;
import gdsc.insangjinsolutionchallenge.domain.example.ExampleRepository;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import gdsc.insangjinsolutionchallenge.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final UserRepository userRepository;
    private final ExampleRepository exampleRepository;

    @Transactional
    public Submission saveSubmission(Long userId, Long exampleId, RequestSubmissionDto requestSubmissionDto) {
        User userinfo = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("올바른 유저 정보를 입력해 주세요."));
        Example example = exampleRepository.findById(exampleId)
                .orElseThrow(() -> new IllegalArgumentException("올바른 문제 번호를 입력해 주세요."));

        Submission submission = Submission.builder()
                .user(userinfo)
                .example(example)
                .userAnswer(requestSubmissionDto.getUserAnswer())
                .build();

        // 유저가 이전에 문제를 맞추었는지 확인
        boolean isPreviouslyCorrect = submissionRepository.existsByUserAndExampleAndCorrect(userinfo, example, true);
        if (isPreviouslyCorrect) {
            throw new IllegalArgumentException("이미 맞춘 문제에 대해선 점수를 받을 수 없습니다.");
        }

        //문제를 맞췄는지 확인
        submission.setCorrect(submission.checkAnswer(example));

        //점수 추가 메서드
        if (submission.isCorrect()) {
            userinfo.addTotalScoreAndUpdateLevel(example.getScore());
        }
        submissionRepository.save(submission);

        userRepository.save(userinfo);

        //정답률 관련 메서드
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
        Example example = exampleRepository.findById(exmapleId).orElseThrow(() -> new IllegalArgumentException("없는 문제입니다."));
        List<Submission> submissions = example.getSubmissions();
        List<ResponseSubmission> responseSubmission = new ArrayList<>();

        List<ResponseSubmission> responseSubmissions = submissions.stream()
                .map(submission -> ResponseSubmission.builder()
                        .userAnswer(submission.getUserAnswer())
                        .correct(submission.isCorrect())
                        .createAt(submission.getCreateAt())
                        .build())
                .toList();

        return responseSubmission;
    }

    private Submission findById(Long submissionId) {
        return submissionRepository.findById(submissionId)
                .orElseThrow(() -> new IllegalArgumentException("정확한 제출 번호를 입력하세요"));
    }
}
