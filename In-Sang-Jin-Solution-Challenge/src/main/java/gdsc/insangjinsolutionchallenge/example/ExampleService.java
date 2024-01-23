package gdsc.insangjinsolutionchallenge.example;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleRepository exampleRepository;
    private final FileService fileService;

    @Transactional
    public Example saveExample(RequestExampleDto requestExampleDto) throws IOException {

        Example example = Example.toEntity(requestExampleDto);
        String imgPath = fileService.saveFile(requestExampleDto.getImg(), requestExampleDto.getTitle());
        if (imgPath == null) {
            imgPath = "https://storage.googleapis.com/download/storage/v1/b/solutionchallenge-lighthouse.appspot.com/o/tkdwls?generation=1705988671269788&alt=media";
        }
        example.saveImgPath(imgPath);
        exampleRepository.save(example);
        return example;

    }

    /* 문제 조회 메서드 */
    @Transactional(readOnly = true)
    public ResponseExampleDto findExample(Long exampleId) {
        Example example = findById(exampleId);
        ResponseExampleDto responseExampleDto = ResponseExampleDto.toDto(example);
        return responseExampleDto;
    }

    @Transactional(readOnly = true)
    public List<Example> findExamples() {
//        int totalSubmissions = Optional.ofNullable(example.getSubmissions())
//                .map(List::size)
//                .orElse(0);
//        if(totalSubmissions==0){
//            example.saveCorrectPercentage(0);
//        }else {
//            int correctSubmissions = (int) example.getSubmissions().stream()
//                    .filter(Submission::isCorrect)
//                    .count();
//            int correctPercentage = correctSubmissions / totalSubmissions;
//            example.saveCorrectPercentage(correctPercentage);
//        }
        return exampleRepository.findAll();
    }

//    /* 정답 조회 메서드 */
//    @Transactional(readOnly = true)
//    public CorrectExampleDto findAnswer(Long exampleId) {
//        return CorrectExampleDto.answerResponseDto(findById(exampleId));
//    }

    @Transactional
    public String updateExample(Long exampleId, RequestExampleDto requestExampleDto) throws IOException {
        Example example = findById(exampleId);
        example.update(requestExampleDto);
        example.saveImgPath(fileService.saveFile(requestExampleDto.getImg(), requestExampleDto.getTitle()));
        return "수정 완료!";
    }

    // 이미지 삭제가 안됨
    @Transactional
    public String deleteExample(Long exampleId) {
        deleteFile(exampleId);
        exampleRepository.delete(findById(exampleId));

        return "삭제 완료!";
    }

    private Example findById(Long exampleId) {
        return exampleRepository.findById(exampleId)
                .orElseThrow(() -> new IllegalArgumentException("문제 번호를 확인해 주세요"));
    }


    public void deleteFile(Long exampleId) {
        Bucket bucket = StorageClient.getInstance().bucket("solutionchallenge-lighthouse.appspot.com");
        String blobName = findById(exampleId).getImgPath();
        Blob blob = bucket.get(blobName);
        if (blob != null) {
            blob.delete();
        } else {
            System.out.println("No file found with the given name");
        }
    }

}
