package gdsc.insangjinsolutionchallenge.user;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService1 {
    private final UserRepository userRepository;
    private final FirebaseAuth firebaseAuth;



    public UserDto login(String token) throws FirebaseAuthException {
        FirebaseToken decodedToken = firebaseAuth.verifyIdToken(token);
        String uid = decodedToken.getUid();

        User user = userRepository.findByUid(uid).orElseGet(() -> {
            User newUser = new User();
            newUser.setFirebaseUid(uid);
            newUser.setEmail(decodedToken.getEmail());
            newUser.setName(decodedToken.getName());
            return userRepository.save(newUser);
        });
        return new UserDto();
    }
}
