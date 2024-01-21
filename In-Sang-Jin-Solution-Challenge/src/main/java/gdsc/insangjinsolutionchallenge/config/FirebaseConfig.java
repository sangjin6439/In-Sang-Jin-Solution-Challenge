package gdsc.insangjinsolutionchallenge.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.StorageClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
@Log4j2
@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException{
        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/firebase.json");

                FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("solutionchallenge-lighthouse.appspot.com")
                .build();

        FirebaseApp app = FirebaseApp.initializeApp(options);
        log.info("FirebaseApp initialized" + app.getName());
        return app;
    }

    @Bean
    public FirebaseAuth getFirebaseAuth() throws IOException {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp());
        return firebaseAuth;
    }

    @Bean
    public Bucket bucket() throws IOException{
        return StorageClient.getInstance(firebaseApp()).bucket();
    }
}
