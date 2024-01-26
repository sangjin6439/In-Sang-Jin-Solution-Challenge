package gdsc.insangjinsolutionchallenge.global.config;


import com.google.firebase.auth.FirebaseAuth;
import gdsc.insangjinsolutionchallenge.domain.user.UserDetailService;
import gdsc.insangjinsolutionchallenge.global.security.entry.CustomAccessDeniedHandler;
import gdsc.insangjinsolutionchallenge.global.security.entry.CustomAuthenticationEntryPoint;
import gdsc.insangjinsolutionchallenge.global.security.filter.FirebaseTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailService userDetailService;
    private final FirebaseAuth firebaseAuth;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize ->
                        authorize.anyRequest()
                                .authenticated())
//                .addFilterBefore(corsFilterRegistrationBean(), ChannelProcessingFilter.class)
                .addFilterBefore(firebaseTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                                .accessDeniedHandler(new CustomAccessDeniedHandler()))
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return webSecurity -> webSecurity.ignoring().requestMatchers("/**","/users/**","/examples/**","/docs/**", "/api-docs/**", "/swagger-ui/**", "/favicon.ico", "/api/v1/information");
    }

    public FirebaseTokenFilter firebaseTokenFilter() {
        return new FirebaseTokenFilter(userDetailService, firebaseAuth);
    }

    //cors
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:5177", "http://localhost:5173");
            }
        };
    }

//    @Bean
//    public Filter corsFilterRegistrationBean() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(false);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.setMaxAge(6000L);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//
//        FilterRegistrationBean<CorsFilter> filterBean = new FilterRegistrationBean<>(new CorsFilter(source));
//        filterBean.setOrder(0);
//
//        return (Filter) filterBean;
//    }


}

