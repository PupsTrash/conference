package conference.service.room;

import conference.controller.api.RoomDto;
import conference.db.RoomEntity;

import java.util.List;
/**
 * main method`s Room Service for Room controller
 */
public interface RoomControllerService {
    List<RoomDto> getAllRoomNumber();

    RoomEntity getRoomById(Long id);
}
