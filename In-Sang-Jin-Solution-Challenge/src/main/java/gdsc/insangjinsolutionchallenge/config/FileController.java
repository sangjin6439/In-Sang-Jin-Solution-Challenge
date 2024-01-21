package gdsc.insangjinsolutionchallenge.config;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService2 fileService;

    @PostMapping("/save")
    public String save(@RequestParam("image") MultipartFile image) throws IOException {
        return fileService.saveFile(image.getBytes());
    }

    @GetMapping("/find/{imgpath}")
    public String  downloadProfile(@PathVariable("imgpath") String imgpath) {
        return fileService.find(imgpath);
    }

}
