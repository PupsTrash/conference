package conference.service.room;

import conference.controller.api.RoomDto;
import conference.db.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RoomControllerServiceMapper {
    public abstract List<RoomDto> toResponse(List<Room> roomList);

    @Mapping(target = "numberRoom", source = "number")
    @Mapping(target = "idRoom", source = "id")
    public abstract RoomDto toResponse(Room room);
}