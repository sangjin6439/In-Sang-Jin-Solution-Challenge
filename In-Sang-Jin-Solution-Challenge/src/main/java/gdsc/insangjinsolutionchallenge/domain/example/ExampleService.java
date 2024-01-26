package gdsc.insangjinsolutionchallenge.domain.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleRepository exampleRepository;


    @Transactional
    public Example saveExample(RequestExampleDto requestExampleDto){
        Example example = Example.toEntity(requestExampleDto);
        exampleRepository.save(example);
        return example;
    }

    /* 문제 조회 메서드 */
    @Transactional(readOnly = true)
    public ResponseExampleDto findExample(Long exampleId) {
        Example example = findById(exampleId);
        ResponseExampleDto responseExampleDto = ResponseExampleDto.toDto(example);
        return responseExampleDto;
    }

    /* 학년과 유형별 문제 조회 메서드 */
    @Transactional(readOnly = true)
    public List<ResponseExampleListDto> findExampleByGradeAndCategory(String grade, String category){
        List<Example> examples = exampleRepository.findByGradeAndCategory(grade,category);
        List<ResponseExampleListDto> responseExampleListDtos = new ArrayList<>();

        for (Example example : examples) {
            ResponseExampleListDto responseExampleListDto =ResponseExampleListDto.builder()
                    .title(example.getTitle())
                    .category(example.getCategory())
                    .content(example.getContent())
                    .grade(example.getGrade())
                    .score(example.getScore())
                    .build();
            responseExampleListDtos.add(responseExampleListDto);
        }
        return responseExampleListDtos;
    }

    @Transactional(readOnly = true)
    public List<Example> findExamples() {
        return exampleRepository.findAll();
    }



    @Transactional
    public String updateExample(Long exampleId, RequestExampleDto requestExampleDto) throws IOException {
        Example example = findById(exampleId);
        example.update(requestExampleDto);
        return "수정 완료!";
    }

    // 이미지 삭제가 안됨
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