package gdsc.insangjinsolutionchallenge.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


//    @PostMapping
//    public String save(@RequestHeader("Authorization") String token, @RequestBody RequestUserDto requestUserDto) {
//        return userService.verifyTokenAndSaveUser(token, requestUserDto);
//    }
//    @PostMapping //인증 없는 테스트용
    public String saveEx(@RequestBody RequestUserDto requestUserDto){
        return userService.saveEx(requestUserDto);
    }

                //    @GetMapping("/me")
                //    public ResponseUserDto find(@PathVariable)

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


    @PatchMapping("/{email}")
    public String update(@PathVariable("email") String email, @RequestBody RequestUserDto requestUserDto) {
        return userService.updateUser(email, requestUserDto);
    }


    @DeleteMapping("/{email}")
    public String delete(@PathVariable("email") String email) {
        return userService.deleteUser(email);
    }

}
