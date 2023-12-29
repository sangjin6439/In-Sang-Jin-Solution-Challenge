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

//    @Transactional(readOnly = true)
//    public RequestExampleDto findExample(Long id) {
//        RequestExampleDto requestExampleDto = exampleRepository.findById(id);
//    }

}
