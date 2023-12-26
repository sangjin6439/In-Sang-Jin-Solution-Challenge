package gdsc.insangjinsolutionchallenge.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public String saveUser(RequestUserDto requestUserDto) {
         userRepository.save(User.toEntity(requestUserDto));
         return "저장 완료!";
    }

    @Transactional(readOnly = true)
    public ResponseUserDto findUser(String email) {
        return ResponseUserDto.toDto(findUserByEmail(email));
    }

    @Transactional
    public String updateUser(String email, RequestUserDto requestUserDto) {
        ResponseUserDto userDto = findUser(email);
        userDto.update(requestUserDto);
        return "수정 완료!";
    }

    @Transactional(readOnly = true)
    public String deleteUser(String email) {
        userRepository.delete(findUserByEmail(email));
        return "삭제 완료!";
    }

    private User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new IllegalArgumentException("이메일을 확인해 주세요."));
    }


}
