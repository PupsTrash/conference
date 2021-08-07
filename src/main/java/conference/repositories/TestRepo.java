package conference.repositories;

import conference.db.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepo extends CrudRepository<Test, String> {
}
