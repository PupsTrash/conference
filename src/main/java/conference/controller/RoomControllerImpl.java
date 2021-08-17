package conference.controller;

import conference.controller.api.RoomDto;
import conference.service.room.RoomControllerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoomControllerImpl implements RoomControllerApi {
    private final RoomControllerService service;

    @Override
    public List<RoomDto> getAllRoom() {
        return service.getAllRoomNumber();
    }
}
