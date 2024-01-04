package gdsc.insangjinsolutionchallenge.user;

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
    public String saveUser(RequestUserDto requestUserDto) {
        userRepository.save(User.toEntity(requestUserDto));
        return "저장 완료!";
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
        return userRepository.findUserByEmail(email).orElseThrow(() -> new IllegalArgumentException("이메일을 확인해 주세요."));
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
