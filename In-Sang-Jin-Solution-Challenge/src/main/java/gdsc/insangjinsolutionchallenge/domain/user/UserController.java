package gdsc.insangjinsolutionchallenge.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @PostMapping("add/info") //추가 정보 입력, 부분적인 사항만 저정할 때에는 patch를 써야함. put을 쓰면 모든 엔티티의 값을 넣어야함
    public String saveEx(@AuthenticationPrincipal User user, @RequestBody RequestUserDto requestUserDto) {
        return userService.saveEx(user, requestUserDto);
    }

    @GetMapping("/my/info") //userDetails쓰면 아래의 어노테이션 써서 유저 정보 확인
    public ResponseUserDto myInfo(@AuthenticationPrincipal User user) {
        return userService.findMyInfo(user);
    }

    @GetMapping("/{email}")
    public ResponseUserDto find(@PathVariable("email") String email) {  //("email")명시하기!
        return userService.findUser(email);
    }

    @GetMapping("/ranking")
    public List<RankingUserDto> findRanking() {
        return userService.findUsersByTotalScore();
    }

    @GetMapping("/ranking/{school}")
    public List<RankingUserDto> findSchoolRanking(@PathVariable("school") String school) {
        return userService.findUsersBySchoolWithTotalScore(school);
    }

    @DeleteMapping("/delete/info")
    public String delete(Principal principal) {
        return userService.deleteUser(principal);
    }

}
