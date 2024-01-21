package gdsc.insangjinsolutionchallenge.config;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService2 {

    private final Bucket bucket;

    public String saveFile(byte[] image) throws IOException {
        String imgPath = String.valueOf(UUID.randomUUID());
        String blob = "/examples/"+imgPath;
//        bucket.create(blob,image);
        bucket.create(blob, image);
        return imgPath;
    }

    public String  find(String imgpath) {
        Blob blob = bucket.get("/examples/"+imgpath);
        return blob.getSelfLink();
    }

}
