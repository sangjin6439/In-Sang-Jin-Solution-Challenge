package gdsc.insangjinsolutionchallenge.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
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

    @PutMapping("/{email}")
    public String update(@PathVariable("email") String email,@RequestBody RequestUserDto requestUserDto){
        return userService.updateUser(email,requestUserDto);
    }

    @DeleteMapping("/{email}")
    public String delete(@PathVariable("email") String email){
        return userService.deleteUser(email);
    }

}
