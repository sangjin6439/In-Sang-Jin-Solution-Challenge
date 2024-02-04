package gdsc.insangjinsolutionchallenge.global.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseInitializer {

    private String jsonFilePath;

//    @PostConstruct
//    public void init() {
//        jsonFilePath = System.getProperty("src/resources/firebase.json");
//    }

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        if(FirebaseApp.getApps().isEmpty()){
            FileInputStream fis = new FileInputStream("src/main/resources/firebase.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(fis))
                    .build();

            return FirebaseApp.initializeApp(options);
        }
        return FirebaseApp.getInstance();

    }
    //환경변수 설정
//    @Bean
//    public FirebaseApp firebaseApp() throws IOException {
//        if(FirebaseApp.getApps().isEmpty()){
//            GoogleCredentials googleCredentials = GoogleCredentials.fromStream(new ByteArrayInputStream(privateKey.getBytes()));
//
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(googleCredentials)
//                    .build();
//                return FirebaseApp.initializeApp(options);
//            }
//            return FirebaseApp.getInstance();
//
//    }


        @Bean
        public FirebaseAuth getFirebaseAuth () throws IOException {
            return FirebaseAuth.getInstance(firebaseApp());
        }

}