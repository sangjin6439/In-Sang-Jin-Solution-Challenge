//package gdsc.insangjinsolutionchallenge.oauth;
//
//import com.google.gson.Gson;
//import gdsc.insangjinsolutionchallenge.user.Role;
//import gdsc.insangjinsolutionchallenge.user.User;
//import gdsc.insangjinsolutionchallenge.user.UserInfo;
//import gdsc.insangjinsolutionchallenge.user.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.URI;
//import java.util.Map;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//
//    private final String GOOGLE_TOKEN_URL = "https://oauth2.googleapis.com/token";
//    @Value("${client_id}")
//    private String GOOGLE_CLIENT_ID;
//    @Value("${client_secret}")
//    private String GOOGLE_CLIENT_SECRET;
//
//    public final String GOOGLE_STUDENT_REDIRECT_URI = "http://localhost:8080/login/oauth2/google/student";
//    public final String GOOGLE_TEACHER_REDIRECT_URI = "http://localhost:8080/login/oauth2/google/teacher";
//    private final UserRepository userRepository;
//    private final TokenProvider tokenProvider;
//
//    public String getGoogleAccessToken(String code, String redirectUri) {
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> params = Map.of(
//                "code", code,
//                "scope", "https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email",
//                "client_id", GOOGLE_CLIENT_ID,
//                "client_secret", GOOGLE_CLIENT_SECRET,
//                "redirect_uri", redirectUri,
//                "grant_type", "authorization_code"
//        );
//
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity(GOOGLE_TOKEN_URL, params, String.class);
//
//        if (responseEntity.getStatusCode().is2xxSuccessful()) {
//            String json = responseEntity.getBody();
//            Gson gson = new Gson();
//
//            return gson.fromJson(json, Token.class)
//                    .getAccessToken();
//        }
//
//        throw new RuntimeException("구글 엑세스 토큰을 가져 오는데 실패했습니다.");
//    }
//
//    @Transactional
//    public Token loginOrSignUp(String googleAccessToken, Role role) {
//        UserInfo userInfo = getUserInfo(googleAccessToken);
//
//        if (!userInfo.getVerifiedEmail()) {
//            throw new RuntimeException("이메일 인증이 되지 않은 유저입니다.");
//        }
//
//        User user = userRepository.findByEmail(userInfo.getEmail()).orElseGet(() ->
//                userRepository.save(User.builder()
//                        .email(userInfo.getEmail())
//                        .name(userInfo.getName())
//                        .pictureUrl(userInfo.getPictureUrl())
//                        .role(role)
//                        .build())
//        );
//
//        return tokenProvider.createToken(user);
//    }
//
//    public UserInfo getUserInfo(String accessToken) {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://www.googleapis.com/oauth2/v2/userinfo?access_token=" + accessToken;
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + accessToken);
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(url));
//        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
//
//        if (responseEntity.getStatusCode().is2xxSuccessful()) {
//            String json = responseEntity.getBody();
//            Gson gson = new Gson();
//            return gson.fromJson(json, UserInfo.class);
//        }
//
//        throw new RuntimeException("유저 정보를 가져오는데 실패했습니다.");
//    }
//}
//
