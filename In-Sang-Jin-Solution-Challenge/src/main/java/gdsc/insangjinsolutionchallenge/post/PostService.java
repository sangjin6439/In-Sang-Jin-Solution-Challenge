//package gdsc.insangjinsolutionchallenge.post;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class PostService {
//    private final PostRepository postRepository;
//
//    @Transactional
//    public String save(RequestPostDto requestPostDto){
//        postRepository.save(Post.toEntity(requestPostDto));
//        return "저장 완료!";
//    }
//
//    @Transactional(readOnly = true)
//    public Post findPost(Long postId){
//
//    }
//
//}
