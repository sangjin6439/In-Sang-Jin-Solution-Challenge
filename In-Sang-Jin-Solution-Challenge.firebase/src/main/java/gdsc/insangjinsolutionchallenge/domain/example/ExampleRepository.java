package gdsc.insangjinsolutionchallenge.domain.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExampleRepository extends JpaRepository<Example,Long> {
    List<Example> findByGradeAndCategory(String grade, String category);
}