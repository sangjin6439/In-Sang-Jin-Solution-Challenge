package gdsc.insangjinsolutionchallenge.domain.like;

import gdsc.insangjinsolutionchallenge.domain.post.Post;
import gdsc.insangjinsolutionchallenge.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    // 있는지 없는지 검토
    boolean existsByUserAndPost(User user, Post post);

    void deleteByUserAndPost(User user, Post post);
}
