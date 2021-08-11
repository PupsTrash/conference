package conference.repositories;

import conference.db.Room;
import conference.db.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
    List<Schedule> findSchedulesByRoom_NumberOrderByStartAt(String room_number);
    List<Schedule> findSchedulesByRoom(Room room);

}
