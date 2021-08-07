package conference.repositories;

import conference.db.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ScheduleRepo extends CrudRepository<Schedule, Long> {
List<Schedule> findAllByIdIsNotNull();
}
