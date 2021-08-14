package conference.service.room;

import conference.controller.api.RoomDto;
import conference.db.RoomEntity;
import conference.repositories.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomControllerServiceImpl implements RoomControllerService {
    private final RoomRepo roomRepo;
    private final RoomControllerServiceMapper mapper;

    @Override
    public List<RoomDto> getAllRoomNumber() {
        return mapper.toResponse(roomRepo.findAll());
    }

    @Override
    public RoomEntity getRoomById(Long id) {
        return roomRepo.getById(id);
    }
}
