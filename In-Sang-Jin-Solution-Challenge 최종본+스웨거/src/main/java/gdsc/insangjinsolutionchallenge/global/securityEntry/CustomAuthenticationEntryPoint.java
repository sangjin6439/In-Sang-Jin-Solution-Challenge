package gdsc.insangjinsolutionchallenge.global.securityEntry;

import gdsc.insangjinsolutionchallenge.global.exception.ApplicationErrorType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.sendError(ApplicationErrorType.NO_AUTHENTICATION.getStatusCode(), ApplicationErrorType.NO_AUTHENTICATION.getMessage());
    }
}
