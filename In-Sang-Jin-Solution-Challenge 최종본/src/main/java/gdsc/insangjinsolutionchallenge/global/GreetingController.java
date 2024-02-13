package gdsc.insangjinsolutionchallenge.global;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {

    @GetMapping("/greeting/{name}")
    public ResponseEntity<String> greeting(@PathVariable String name) {
        return ResponseEntity.ok(String.format("Hello %s.", name));
    }
}