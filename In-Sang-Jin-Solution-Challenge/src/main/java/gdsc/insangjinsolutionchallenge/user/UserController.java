package gdsc.insangjinsolutionchallenge.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
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

    @GetMapping//DTO로 매핑 아직 안함
    public List<User> findUsers(){
        return userService.findUsers();
    }

    @PatchMapping("/{email}")
    public String update(@PathVariable("email") String email,@RequestBody RequestUserDto requestUserDto){
        return userService.updateUser(email,requestUserDto);
    }

    @DeleteMapping("/{email}")
    public String delete(@PathVariable("email") String email){
        return userService.deleteUser(email);
    }

}
