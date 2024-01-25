package gdsc.insangjinsolutionchallenge.global.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Configuration
public class FirebaseInitializer {

    @Value("${firebase.private_key}")
    private String privateKey;

//    @Value("${firebase.json-file-path}")
//    private String jsonFilePath;

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            // 클래스패스 상의 리소스를 로드
//            Resource resource = new ClassPathResource(jsonFilePath);
//
//            // 리소스에서 InputStream을 얻음
//            try (InputStream fis = resource.getInputStream()) {
//                FirebaseOptions options = FirebaseOptions.builder()
//                        .setCredentials(GoogleCredentials.fromStream(fis))
//                        .build();
            GoogleCredentials googleCredentials = GoogleCredentials.fromStream(new ByteArrayInputStream(privateKey.getBytes()));

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(googleCredentials)
                    .build();
                return FirebaseApp.initializeApp(options);
            }

        return FirebaseApp.getInstance();
    }


    @Bean
    public FirebaseAuth getFirebaseAuth() throws IOException{
        return FirebaseAuth.getInstance(firebaseApp());
    }
}

