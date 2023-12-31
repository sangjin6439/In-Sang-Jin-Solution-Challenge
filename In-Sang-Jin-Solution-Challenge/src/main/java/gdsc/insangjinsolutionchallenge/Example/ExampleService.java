package gdsc.insangjinsolutionchallenge.Example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleRepository exampleRepository;
    private final FileService fileService;

    @Transactional
    public Example saveExample(RequestExampleDto requestExampleDto) throws IOException {

        Example example = Example.toEntity(requestExampleDto);
        example.saveImgPath(fileService.saveFile(requestExampleDto.getImg()));
        exampleRepository.save(example);
        return example;
    }

    /* 문제 조회 메서드 (정답x)*/
    @Transactional(readOnly = true)
    public WithOutAnswerResponseExampleDto findExample(Long exampleId) {
        Example example = findById(exampleId);
        WithOutAnswerResponseExampleDto responseExampleDto = WithOutAnswerResponseExampleDto.toDto(example);
        return responseExampleDto;
    }

    @Transactional(readOnly = true)
    public List<Example> findExamples() {
        return exampleRepository.findAll();
    }

    /* 정답 조회 메서드 */
    @Transactional(readOnly = true)
    public AnswerResponseDto findAnswer(Long exampleId) {
        return AnswerResponseDto.answerResponseDto(findById(exampleId));
    }

    @Transactional
    public String updateExample(Long exampleId, RequestExampleDto requestExampleDto) throws IOException {
        Example example = findById(exampleId);
        example.update(requestExampleDto);
        example.saveImgPath(fileService.saveFile(requestExampleDto.getImg()));
        return "수정 완료!";
    }

    @Transactional
    public String deleteExample(Long exampleId) {
        exampleRepository.delete(findById(exampleId));
        return "삭제 완료!";
    }

    private Example findById(Long exampleId) {
        return exampleRepository.findById(exampleId)
                .orElseThrow(() -> new IllegalArgumentException("문제 번호를 확인해 주세요"));
    }

}
