package conference.service.room;

import conference.controller.api.RoomDto;
import conference.db.Room;
import conference.repositories.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomControllerService {
    private final RoomRepo roomRepo;
    private final RoomControllerServiceMapper mapper;

    public List<RoomDto> getAllRoomNumber(){
        return mapper.toResponse(roomRepo.findAll());
    }

    public Room getRoomById(Long id){
        return roomRepo.getById(id);
    }
}
