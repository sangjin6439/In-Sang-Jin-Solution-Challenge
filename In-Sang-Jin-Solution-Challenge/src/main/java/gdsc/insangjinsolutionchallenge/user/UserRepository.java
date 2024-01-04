package gdsc.insangjinsolutionchallenge.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    @Query("SELECT u FROM User u ORDER BY u.totalScore DESC ")
    List<User> findUsersByTotalScore();

    @Query("SELECT u FROM User u Where u.school = :school ORDER BY u.totalScore DESC")
    List<User> findUsersBySchoolWithTotalScore(@Param("school") String school);


}
