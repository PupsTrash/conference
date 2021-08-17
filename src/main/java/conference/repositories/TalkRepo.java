package conference.repositories;

import conference.db.TalkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkRepo extends JpaRepository<TalkEntity, Long> {
    TalkEntity findByTitleAndDescription(String title, String description);
}
