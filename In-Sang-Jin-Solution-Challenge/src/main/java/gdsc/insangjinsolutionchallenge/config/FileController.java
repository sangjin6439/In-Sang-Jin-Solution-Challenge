//package gdsc.insangjinsolutionchallenge.config;
//
//import gdsc.insangjinsolutionchallenge.example.FileService2;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequiredArgsConstructor
//public class FileController {
//
//    private final FileService2 fileService;
//
//    @PostMapping("/save")
//    public String save(@RequestParam("image") MultipartFile image,@RequestParam("nameFile")String nameFile) throws IOException {
//        return fileService.saveFile(image,nameFile);
//    }
//
//    @GetMapping("/find/{imgPath}")
//    public String  downloadProfile(@PathVariable("imgPath") String imgPath) {
//        return fileService.find(imgPath);
//    }
//
//}
