package gdsc.insangjinsolutionchallenge.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public String save(@RequestBody RequestUserDto requestuserDto){
        return userService.saveUser(requestuserDto);
    }

    @GetMapping("/{email}")
    public ResponseUserDto find(@PathVariable("email") String email){  //("email")명시하기!
        return userService.findUser(email);
    }

    @GetMapping("/ranking")
    public List<RankingUserDto> findRanking(){
        return userService.findUsersByTotalScore();
    }

    @GetMapping("/ranking/{school}")
    public List<RankingUserDto> findSchoolRanking(@PathVariable("school") String school){
        return userService.findUsersBySchoolWithTotalScore(school);
    }

//    @GetMapping("/ranking/school")  /*아직 손봐야함 작동 안됨*/
//    public ResponseEntity<List<RankingUserDto>> findSchoolRanking(@RequestParam String school){
//        return ResponseEntity.ok(userService.findUsersBySchoolWithTotalScore(school));
//    }


    @PatchMapping("/{email}")
    public String update(@PathVariable("email") String email,@RequestBody RequestUserDto requestUserDto){
        return userService.updateUser(email,requestUserDto);
    }


    @DeleteMapping("/{email}")
    public String delete(@PathVariable("email") String email){
        return userService.deleteUser(email);
    }

}
