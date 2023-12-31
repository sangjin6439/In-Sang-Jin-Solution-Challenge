package gdsc.insangjinsolutionchallenge.submission;

import gdsc.insangjinsolutionchallenge.Example.Example;
import gdsc.insangjinsolutionchallenge.Example.ExampleRepository;
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

        // 빌더를 사용하여 Submission 객체를 생성합니다.
        Submission submission = Submission.builder()
                .user(user)
                .example(example)
                .userAnswer(requestSubmissionDto.getUserAnswer())
                .build();

        // 정답 여부를 확인한 후 correct 값을 설정합니다.
        submission.setCorrect(submission.checkAnswer(example)); // checkAnswer 메서드의 시그니처가 example을 인자로 받도록 되어 있으므로 전달합니다.

        // 정답이 맞다면 사용자의 점수를 업데이트합니다.
        if (submission.isCorrect()) {
            user.addTotalScore(example.getScore());
        }

        // 변경된 사용자 정보를 저장합니다.
        userRepository.save(user);

        // 완성된 Submission 객체를 저장합니다.
        return submissionRepository.save(submission);
    }

//    @Transactional
//    public Submission saveSubmission1(RequestSubmissionDto requestSubmissionDto) {
//        User user = userRepository.findById(requestSubmissionDto.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("올바른 유저 정보를 입력해 주세요."));
//        Example example = exampleRepository.findById(requestSubmissionDto.getExampleId())
//                .orElseThrow(() -> new IllegalArgumentException("올바른 문제 번호를 입력해 주세요."));
//
//
//        Submission submission = new Submission();
//        if (submission.checkAnswer()){
//            user.addTotalScore(example.getScore());
//        }
//        submission = Submission.builder()
//                .user(user)
//                .example(example)
//                .userAnswer(requestSubmissionDto.getUserAnswer())
//                .correct(submission.checkAnswer())
//                .build();
//        return submissionRepository.save(submission);
//
//
//    }

    @Transactional(readOnly = true)
    public ResponseSubmission findSubmission(Long submissionId) {
        Submission submission = findById(submissionId);
        return ResponseSubmission.builder()
                .userAnswer(submission.getUserAnswer())
                .correct(submission.isCorrect()) // ????????????/
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
