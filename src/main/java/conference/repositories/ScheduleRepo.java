package conference.repositories;

import conference.db.RoomEntity;
import conference.db.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<ScheduleEntity, Long> {
    List<ScheduleEntity> findScheduleEntityByRoomEntity_NumberOrderByStartAt(String number);

    List<ScheduleEntity> findScheduleEntityByRoomEntity(RoomEntity roomEntity);

}
