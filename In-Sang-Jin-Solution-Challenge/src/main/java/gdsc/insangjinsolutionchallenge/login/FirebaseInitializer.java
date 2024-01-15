//package gdsc.insangjinsolutionchallenge.login;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.auth.FirebaseAuth;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@Log4j2
//@Configuration
//public class FirebaseInitializer {
//
//    @Bean
//    public FirebaseApp firebaseApp() throws IOException {
//        log.info("Initializing Firebase");
//        FileInputStream serviceAccount =
//                new FileInputStream("/Users/sangjin-in/Downloads/firebase.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .setStorageBucket("LightHouse.appspot.com")
//                .build();
//
//        FirebaseApp app = FirebaseApp.initializeApp(options);
//        log.info("FirebaseApp initialized" + app.getName());
//        return app;
//    }
//
//    @Bean
//    public FirebaseAuth getFirebaseAuth() throws IOException {
//        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp());
//        return firebaseAuth;
//    }
//}
