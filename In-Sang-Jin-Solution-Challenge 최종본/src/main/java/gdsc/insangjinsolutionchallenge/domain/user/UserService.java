package gdsc.insangjinsolutionchallenge.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    @Transactional //추가 정보 입력
    public String saveEx(Long userId, RequestExUserDto requestUserDto) {
        User userInfo = findUserById(userId);
        userInfo.updateUser(requestUserDto);
        return "저장 완료";
    }

    @Transactional(readOnly = true)
    public ResponseExUserDto findMyInfo(Long userId) {
        return ResponseExUserDto.toDto(findUserById(userId));
    }

    @Transactional(readOnly = true)
    public ResponseExUserDto findUser(String email) {
        return ResponseExUserDto.toDto(findUserByEmail(email));
    }

    @Transactional(readOnly = true)
    public List<RankingUserDto> findUsersByTotalScore() {
        List<User> userList = userRepository.findUsersByTotalScore();
        return getRankingUserDtos(userList);
    }

    @Transactional(readOnly = true)
    public List<RankingUserDto> findUsersBySchoolWithTotalScore(String school) {
        List<User> userList = userRepository.findUsersBySchoolWithTotalScore(school);
        return getRankingUserDtos(userList);

    }

    @Transactional
    public String deleteUser(Principal principal) {
        userRepository.delete(findUserById(Long.valueOf(principal.getName())));
        return "삭제 완료!";
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디를 확인해 주세요."));
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
                    .level(user.getLevel())
                    .build();
            rankingUserDtos.add(rankingUserDto);
        }
        return rankingUserDtos;
    }

    /////////////////////
//    public User findMemberInfoById(Long memberId) {
//        return memberRepository.findById(memberId)
//                .map(MemberResponseDto::of)
//                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
//    }
//
//    public MemberResponseDto findMemberInfoByEmail(String email) {
//        return memberRepository.findByEmail(email)
//                .map(MemberResponseDto::of)
//                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
//    }

}
