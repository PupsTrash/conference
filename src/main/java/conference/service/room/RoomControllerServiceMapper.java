package conference.service.room;

import conference.controller.api.RoomDto;
import conference.db.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RoomControllerServiceMapper {
    public abstract List<RoomDto> toResponse(List<RoomEntity> roomEntityList);

    @Mapping(target = "numberRoom", source = "number")
    public abstract RoomDto toResponse(RoomEntity roomEntity);
}
