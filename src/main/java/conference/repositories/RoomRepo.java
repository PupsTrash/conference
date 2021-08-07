package conference.repositories;

import conference.db.Room;
import org.springframework.data.repository.CrudRepository;


public interface RoomRepo extends CrudRepository<Room, Long> {
}
