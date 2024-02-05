//package gdsc.insangjinsolutionchallenge.login;
//
//import com.google.firebase.auth.FirebaseAuth;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
//// 이 어노테이션 가운대 줄 그어져있음 공식문서나 따로 찾아서 다른 버전보기
//@RequiredArgsConstructor
//public class FirebaseSecurityConfig {
//
//    private UserDetailsService userDetailsService;
//    private FirebaseAuth firebaseAuth;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().anyRequest().authenticated().and()
//                .addFilterBefore(new FirebaseTokenFilter(userDetailsService, firebaseAuth), UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
//
//        return http.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        // /users이거는 post만 인증안함 /submissions/examples로 시작하는 url은 인증안함
//        return (web) -> web.ignoring()
////                .requestMatchers(HttpMethod.GET,"/users")
//                .requestMatchers("swagger-ui/**")
//                .requestMatchers("/users/**")
//                .requestMatchers("/submissions/**")
//                .requestMatchers("/examples/**");
//    }
//
//
//}
