package gdsc.insangjinsolutionchallenge.global.oauth;

import gdsc.insangjinsolutionchallenge.domain.TokenDto;
import gdsc.insangjinsolutionchallenge.domain.TokenRequestDto;
import gdsc.insangjinsolutionchallenge.domain.user.LoginUserDto;
import jakarta.validation.Valid;
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
    public String signup(@RequestBody @Valid LoginUserDto loginUserDto) {
        return authService.signup(loginUserDto);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody @Valid LoginUserDto loginUserDto) {
        return ResponseEntity.ok(authService.login(loginUserDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}
