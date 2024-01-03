package gdsc.insangjinsolutionchallenge.Example;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/examples")
public class ExampleController {

    private final ExampleService exampleService;

    @PostMapping
    public Example save(RequestExampleDto requestExampleDto) throws IOException {
        return exampleService.saveExample(requestExampleDto);
    }

    @GetMapping("/{id}")
    public WithOutAnswerResponseExampleDto find(@PathVariable("id") Long id){
        return exampleService.findExample(id);
    }

    @GetMapping //DTO로 매핑 해야힘
    public List<Example> findAll(){
        return exampleService.findExamples();
    }

    @GetMapping("/answers/{id}")
    public AnswerResponseDto findAnswer(@PathVariable("id") Long id){
        return exampleService.findAnswer(id);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") Long id, RequestExampleDto requestExampleDto) throws IOException {
        return exampleService.updateExample(id,requestExampleDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        return exampleService.deleteExample(id);
    }
}
