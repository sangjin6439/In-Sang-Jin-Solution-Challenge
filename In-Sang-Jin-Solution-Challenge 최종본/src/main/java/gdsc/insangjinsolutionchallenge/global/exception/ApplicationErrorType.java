package gdsc.insangjinsolutionchallenge.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ApplicationErrorType {
    //400
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "요청값이 올바르지 않습니다."),
    INVALID_HEADER(HttpStatus.BAD_REQUEST, "Header 값이 올바르지 않습니다."),
    INVALID_FIREBASE_TOKEN(HttpStatus.BAD_REQUEST, "토큰이 올바르지 않습니다."),
    //401
    NO_AUTHENTICATION(HttpStatus.UNAUTHORIZED, "인증되지 않은 사용자입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "권한이 없습니다."),
    //404
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    //500
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 문제가 발생했습니다. 잠시만 기다려주세요.");

    private final HttpStatus httpStatus;

    private final String message;

    public int getStatusCode() {
        return httpStatus.value();
    }
}
