package gdsc.insangjinsolutionchallenge.Example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

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
         ResponseExampleDto responseExampleDto= ResponseExampleDto.toDto(findById(exampleId));
         return responseExampleDto;
    }


    private Example findById(Long exampleId){
        return exampleRepository.findById(exampleId)
                .orElseThrow(()->new IllegalArgumentException("문제 번호를 확인해 주세요"));
    }

}
