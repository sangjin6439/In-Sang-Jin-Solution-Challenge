package gdsc.insangjinsolutionchallenge.domain.example;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "문제 API", description = "문제관련 API.")
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
    public List<ResponseExampleListDto> findAll(){
        return exampleService.findExamples();
    }

    //플러터에서 바디에 값을 넣고 get요청이 안돼서 post로 요청함(오류 발생해서 param으로 넘김), 패스밸류로 두개 넘기니까 두번 send해야 인식했음
    @GetMapping("/find")
    public List<ResponseExampleListDto> findByGradeAndCategory(@RequestParam("grade") String grade, @RequestParam("category") String category){
        return exampleService.findExampleByGradeAndCategory(grade,category);
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
