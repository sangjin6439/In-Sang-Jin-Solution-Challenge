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

    @Transactional(readOnly = true)
    public ResponseExampleDto findExample(Long exampleId) {
        Example example = findById(exampleId);
         ResponseExampleDto responseExampleDto= ResponseExampleDto.toDto(example);
         return responseExampleDto;
    }

    @Transactional(readOnly = true)
    public List<Example> findExamples(){
        return exampleRepository.findAll();
    }

    @Transactional
    public String updateExample(Long exampleId, RequestExampleDto requestExampleDto) throws IOException {
        Example example = findById(exampleId);
        example.update(requestExampleDto);
        example.saveImgPath(fileService.saveFile(requestExampleDto.getImg()));
        return "수정 완료!";
    }

    @Transactional
    public String deleteExample(Long exampleId){
        exampleRepository.delete(findById(exampleId));
        return "삭제 완료!";
    }

    private Example findById(Long exampleId){
        return exampleRepository.findById(exampleId)
                .orElseThrow(()->new IllegalArgumentException("문제 번호를 확인해 주세요"));
    }

}
