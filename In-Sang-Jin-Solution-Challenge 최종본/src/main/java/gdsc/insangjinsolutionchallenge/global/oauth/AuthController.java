package gdsc.insangjinsolutionchallenge.global.oauth;

import gdsc.insangjinsolutionchallenge.domain.TokenDto;
import gdsc.insangjinsolutionchallenge.domain.TokenRequestDto;
import gdsc.insangjinsolutionchallenge.domain.user.RequestUserDto;
import gdsc.insangjinsolutionchallenge.domain.user.ResponseUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseUserDto> signup(@RequestBody RequestUserDto requestUserDto) {
        return ResponseEntity.ok(authService.signup(requestUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody RequestUserDto requestUserDto) {
        return ResponseEntity.ok(authService.login(requestUserDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}
