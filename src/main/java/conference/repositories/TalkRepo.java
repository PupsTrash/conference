package conference.repositories;

import conference.db.Talk;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TalkRepo extends CrudRepository<Talk, Long> {
    List<Talk> findAllByTitleNotNull();
}
