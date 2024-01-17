package gdsc.insangjinsolutionchallenge.oauth;

import gdsc.insangjinsolutionchallenge.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login/oauth2/google/{role}")
    public Token googleCallback(@RequestParam(name = "code") String code, @PathVariable("role") String role) {
        String redirectUri = role.equals("student") ? authService.GOOGLE_STUDENT_REDIRECT_URI : authService.GOOGLE_TEACHER_REDIRECT_URI;
        String googleAccessToken = authService.getGoogleAccessToken(code, redirectUri);
        return loginOrSignup(googleAccessToken, Role.valueOf(role.toUpperCase()));
    }

    public Token loginOrSignup(String googleAccessToken, Role role) {
        return authService.loginOrSignUp(googleAccessToken, role);
    }


//    @GetMapping("/login/oauth2/google/teacher")
//    public Token googleTeacherCallback(@RequestParam(name = "code") String code) {
//        String googleAccessToken = authService.getGoogleTeacherAccessToken(code);
//        return teacherLoginOrSignup(googleAccessToken);
//    }
//
//    public Token teacherLoginOrSignup(String googleAccessToken) {
//        return authService.teacherLoginOrSignUp(googleAccessToken);
//    }
}