package conference.controller;

import conference.controller.api.RoomDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "Room controller")
@RequestMapping("/room")
public interface RoomControllerApi {

    @GetMapping
    List<RoomDto> getAllRoom();
}
