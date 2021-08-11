package conference.service.schedule;

import conference.controller.api.ScheduleAddResponse;
import conference.controller.api.ScheduleResponseDto;
import conference.db.ScheduleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ScheduleMapper {

    public abstract List<ScheduleResponseDto> toResponse(List<ScheduleEntity> scheduleEntityList);

    @Mapping(target = "title", source = "talkEntity.title")
    @Mapping(target = "description", source = "talkEntity.description")
    @Mapping(target = "roomNumber", source = "roomEntity.number")
    public abstract ScheduleResponseDto toResponse(ScheduleEntity scheduleEntity);

    @Mapping(target = "title", source = "talkEntity.title")
    @Mapping(target = "description", source = "talkEntity.description")
    @Mapping(target = "roomNumber", source = "roomEntity.number")
    public abstract ScheduleAddResponse toAddResponses(ScheduleEntity scheduleEntity);
}
