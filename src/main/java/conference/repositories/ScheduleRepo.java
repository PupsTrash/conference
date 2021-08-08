package conference.repositories;

import conference.db.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
List<Schedule> findAllByIdIsNotNull();
}
