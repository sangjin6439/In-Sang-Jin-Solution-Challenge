package gdsc.insangjinsolutionchallenge.problem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Problem {
    @Id
    @GeneratedValue
    private Long id;
}
