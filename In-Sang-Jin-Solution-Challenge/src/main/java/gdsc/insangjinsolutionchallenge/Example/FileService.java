package gdsc.insangjinsolutionchallenge.Example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Value("${file.dir}")
    private String fileDir;

    public String saveFile(MultipartFile multipartFile) throws IOException {
        String imgPath = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        multipartFile.transferTo(new File(fileDir + imgPath));
        return fileDir + imgPath;
    }

}
