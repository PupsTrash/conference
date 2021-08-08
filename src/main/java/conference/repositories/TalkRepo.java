package conference.repositories;

import conference.db.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TalkRepo extends JpaRepository<Talk, Long> {
    List<Talk> findAllByTitleNotNull();
}
