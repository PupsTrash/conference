package conference.controller;

import conference.controller.api.RoomDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * simple room controller. Add, edit and delete only from database request
 */

@Tag(name = "Room controller")
@RequestMapping("/room")
public interface RoomControllerApi {

    @GetMapping
    List<RoomDto> getAllRoom();
}
