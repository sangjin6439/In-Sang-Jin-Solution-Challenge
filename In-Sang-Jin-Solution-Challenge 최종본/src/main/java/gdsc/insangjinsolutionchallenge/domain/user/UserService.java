package gdsc.insangjinsolutionchallenge.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    @Transactional //추가 정보 입력
    public String saveEx(Long userId, RequestUserDto requestUserDto) {
        User userInfo = findUserById(userId);
        userInfo.updateUser(requestUserDto);
        return "저장 완료";
    }

    @Transactional(readOnly = true)
    public ResponseUserDto findMyInfo(Long userId) {
        User user = findUserById(userId);
        return ResponseUserDto.toDto(user);
    }

    @Transactional(readOnly = true)
    public ResponseUserDto findUser(String email) {
        return ResponseUserDto.toDto(findUserByEmail(email));
    }

    @Transactional(readOnly = true)
    public List<RankingUserDto> findUsersByTotalScore() {
        List<User> userList = userRepository.findUsersByTotalScore();
        return getRankingUserDtos(userList);
    }

    @Transactional(readOnly = true)
    public List<RankingUserDto> findUsersBySchoolWithTotalScore(String school) {
        List<User> userList = userRepository.findBySchoolOrderByTotalScoreDesc(school);
        return getRankingUserDtos(userList);

    }

    @Transactional
    public String deleteUser(Long userId) {

        userRepository.delete(findUserById(userId));
        return "삭제 완료!";
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디를 확인해 주세요."));
    }

    private User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("이메일을 확인해 주세요."));
    }

    private List<RankingUserDto> getRankingUserDtos(List<User> userList) {
        return userList.stream()
                .map(user -> RankingUserDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .totalScore(user.getTotalScore())
                        .level(user.getLevel())
                        .build())
                .toList();
    }




}
