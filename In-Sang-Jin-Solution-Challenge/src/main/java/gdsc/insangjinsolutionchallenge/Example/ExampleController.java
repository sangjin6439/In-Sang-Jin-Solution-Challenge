package gdsc.insangjinsolutionchallenge.Example;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/example")
public class ExampleController {

    private final ExampleService exampleService;

    @PostMapping
    public Example save(RequestExampleDto requestExampleDto) throws IOException {
        return exampleService.saveExample(requestExampleDto);
    }



}
