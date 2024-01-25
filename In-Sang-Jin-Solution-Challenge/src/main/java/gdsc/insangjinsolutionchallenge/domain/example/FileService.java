package gdsc.insangjinsolutionchallenge.domain.example;

//import com.google.firebase.cloud.StorageClient;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//@Service
//@RequiredArgsConstructor
//public class FileService {
//
//    private final Bucket bucket;
//
//    public String saveFile(MultipartFile image, String nameFile) throws IOException {
//
//        Bucket bucket = StorageClient.getInstance().bucket("solutionchallenge-lighthouse.appspot.com");
//        InputStream content = new ByteArrayInputStream(image.getBytes());
//        Blob blob =bucket.create(nameFile.toString(),content,image.getContentType());
//        return blob.getMediaLink();
//    }
//}
