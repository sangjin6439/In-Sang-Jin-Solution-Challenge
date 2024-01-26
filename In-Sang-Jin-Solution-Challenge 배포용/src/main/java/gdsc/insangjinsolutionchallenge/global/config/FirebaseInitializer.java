package gdsc.insangjinsolutionchallenge.global.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseInitializer {

//    @Value("${spring.firebase.privateKey}")
//    private String privateKey;

//    @Value("${firebase.filePath}")
    private String jsonFilePath;

    @PostConstruct
    public void init() {
        jsonFilePath = System.getProperty("firebase.filePath");
    }

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        if(FirebaseApp.getApps().isEmpty()){
            FileInputStream fis = new FileInputStream(jsonFilePath);

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(fis))
                    .build();

            return FirebaseApp.initializeApp(options);
        }
        return FirebaseApp.getInstance();

    }
    //환경변수 설정
//            GoogleCredentials googleCredentials = GoogleCredentials.fromStream(new ByteArrayInputStream(privateKey.getBytes()));
//
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(googleCredentials)
//                    .build();
//                return FirebaseApp.initializeApp(options);
//            }



        @Bean
        public FirebaseAuth getFirebaseAuth () throws IOException {
            return FirebaseAuth.getInstance(firebaseApp());
        }

}