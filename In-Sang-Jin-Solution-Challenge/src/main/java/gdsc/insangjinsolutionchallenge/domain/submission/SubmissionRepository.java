package gdsc.insangjinsolutionchallenge.domain.submission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Long> {
    @Query("SELECT s FROM Submission s JOIN FETCH s.user u JOIN FETCH s.example e")
    List<Submission> findAllWithUserAndExample();
}
