package gdsc.insangjinsolutionchallenge.domain.example;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/examples")
public class ExampleController {

    private final ExampleService exampleService;

    @PostMapping("/save")
    public Example save(@RequestBody RequestExampleDto requestExampleDto) {
        return exampleService.saveExample(requestExampleDto);
    }

    @GetMapping("/{id}")
    public ResponseExampleDto find(@PathVariable("id") Long id){
        return exampleService.findExample(id);
    }

    @GetMapping("/all") //DTO로 매핑 해야함-> 카테고리별로 나누고 페이징해야함
    public List<Example> findAll(){
        return exampleService.findExamples();
    }

    @GetMapping("/find")
    public List<ResponseExampleListDto> findByGradeAndCategory(@RequestBody GradeAndCategory gradeAndCategory){
        return exampleService.findExampleByGradeAndCategory(gradeAndCategory.getGrade(),gradeAndCategory.getCategory());
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
