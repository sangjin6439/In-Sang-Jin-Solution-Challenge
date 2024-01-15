package gdsc.insangjinsolutionchallenge.user;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import gdsc.insangjinsolutionchallenge.exception.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public String verifyTokenAndSaveUser(String token, RequestUserDto requestUserDto) {
        String idToken = token.substring(7); //Bearer 제거
        try{
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();
            User user = User.toEntity(requestUserDto);
            //FirebaseUid 저장
            user.addFirebaseUid(uid,email);
            userRepository.save(user);
        }catch (FirebaseAuthException e){
            //토큰 검증 실패
            throw new InvalidTokenException("Invalid token");
        }
        return "저장 완료!";
    }
    @Transactional
    public String saveEx(RequestUserDto requestUserDto){
        userRepository.save(User.toEntity(requestUserDto));
        return "저장 완료";
    }

    @Transactional(readOnly = true)
    public ResponseUserDto findUser(String email) {
        return ResponseUserDto.toDto(findUserByEmail(email));
    }

    @Transactional(readOnly = true)
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<RankingUserDto> findUsersByTotalScore(){
        List<User> userList = userRepository.findUsersByTotalScore();
        return getRankingUserDtos(userList);
    }
//    private TemplateResponse.UserResponse findUser(String token){
//        try{
//            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
//            String email = decodedToken.getEmail();
//        }catch (FirebaseAuthException e){
//            //토큰 검증 실패
//            throw new InvalidTokenException("Invalid token");
//        }
//        return UserReuserRepository.findUserByEmail(email);
//    }


    @Transactional(readOnly = true)
    public List<RankingUserDto> findUsersBySchoolWithTotalScore(String school) {
        List<User> userList = userRepository.findUsersBySchoolWithTotalScore(school);
        return getRankingUserDtos(userList);

    }

    @Transactional
    public String updateUser(String email, RequestUserDto requestUserDto) {
        User user = findUserByEmail(email);
        user.update(requestUserDto);
        return "수정 완료!";
    }

    @Transactional
    public String deleteUser(String email) {
        userRepository.delete(findUserByEmail(email));
        return "삭제 완료!";
    }



    private User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("이메일을 확인해 주세요."));
    }

    private List<RankingUserDto> getRankingUserDtos(List<User> userList) {
        List<RankingUserDto> rankingUserDtos = new ArrayList<>();

        for (User user : userList) {
            RankingUserDto rankingUserDto = RankingUserDto.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .totalScore(user.getTotalScore())
                    .tier(user.getTier())
                    .build();
            rankingUserDtos.add(rankingUserDto);
        }
        return rankingUserDtos;
    }

}
