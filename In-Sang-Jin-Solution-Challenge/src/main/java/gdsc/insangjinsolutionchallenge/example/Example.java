package gdsc.insangjinsolutionchallenge.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Example {
    @Id
    @GeneratedValue
    private Long id;
}
